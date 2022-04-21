package no.hvl.dat109.proj2.yatzy.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.Dice;
import no.hvl.dat109.proj2.yatzy.entities.GameInstance;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.Score;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleBigStraight;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleBonus;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleChance;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleFourOfAKind;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleHouse;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleOnePair;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleSmallStraight;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleSum;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleTwoPair;
import no.hvl.dat109.proj2.yatzy.services.rules.RuleYatzy;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesThreeOfAKind;

@Stateful
public class GameLogicService {
	
	private static final RulesADT[] RULES = new RulesADT[] {
		new RuleSum(1), // 0
		new RuleSum(2), // 1
		new RuleSum(3), // 2
		new RuleSum(4), // 3
		new RuleSum(5), // 4
		new RuleSum(6), // 5
		new RuleBonus(), // 6
		new RuleOnePair(), // 7
		new RuleTwoPair(), // 8
		new RulesThreeOfAKind(), // 9
		new RuleFourOfAKind(), // 10
		new RuleSmallStraight(), // 11
		new RuleBigStraight(), // 12
		new RuleHouse(), // 13
		new RuleChance(), // 14
		new RuleYatzy(), // 15
	};
	
	private static final ConcurrentHashMap<Integer, GameInstance> instances = new ConcurrentHashMap<Integer, GameInstance>();
	
	@EJB private PlayerDAO playerDao;
	
	public GameLogicService() {
	}
	
	public void createInstance(Lobby lobby, int[] players) {
		instances.put(lobby.getId(), new GameInstance(lobby, players));
	}
	
	public int[] throwDices(Lobby lobby, Player player, boolean[] toKeep) {

		GameInstance instance = instances.get(lobby.getId());
		
		if (player.getId() != instance.getCurPlayerId()) {
			System.out.println("Invalid user!!!");
			return null;
		}
		
		if (instance.getCurRound() == 6) {
			int sum = 0;
			int bonus = 0;
			
			Score score = playerDao.getScoreCard(player.getId());
			int[] scoreArr = score.getScoresAsArray();
			for (int i = 0; i < 5; i++) {
				sum += scoreArr[i];
			}
			if (sum >= 63) {
				bonus = 50;
			}
			else {
				bonus = 0;
			}
			score.setValue(6, bonus);
			playerDao.saveScoreCard(score);
			return new int[] {
				sum,
				bonus
			};
		}
		
		Dice[] dices = instance.getDices();
		int[] values = new int[dices.length];
		
		for (int i = 0; i < dices.length; i++) {
			if (!toKeep[i] || instance.getCurThrow() == 0) {
				dices[i].rollDice();
			}
			values[i] = dices[i].getValue();
		}
		
		System.out.println("current throw " + instance.getCurThrow());
		instance.setCurThrow(instance.getCurThrow()+1);;
		
		return values;
	}
	
	public String getPlayerName(Lobby lobby) {
		GameInstance instance = instances.get(lobby.getId());
		int playerId = instance.getCurPlayerId();
		return playerDao.get(playerId).getUsername();
	}
	
	public int getCurrentRound(Lobby lobby) {
		GameInstance instance = instances.get(lobby.getId());
		return instance.getCurRound();
	}
	
	public boolean playerDone(Lobby lobby, Player player) {
		System.out.println("checking if " + player.getUsername() + " is done");
		GameInstance instance = instances.get(lobby.getId());
		int rounds = instance.getCurRound();
		int diceThrows = instance.getCurThrow();
		int playerId = instance.getCurPlayerId();
		System.out.println(playerId + " == " + player.getId() + " throws " + diceThrows);
		if (playerId == player.getId()) {
			if (rounds == 15) {
				return diceThrows >= 5;
			}
			else if (rounds == 6) {
				return true;
			}
			else {
				return diceThrows >= 3;
			}
		}
		else {
			return false;
		}
	}
	
	public void nextPlayer(Lobby lobby) {
		System.out.println("Going to next player");
		GameInstance instance = instances.get(lobby.getId());
		instance.nextPlayer();
	}
	
	public int getScore(Lobby lobby, Player player, int[] diceValues) {
		GameInstance instance = instances.get(lobby.getId());
		
		Score score = playerDao.getScoreCard(instance.getCurPlayerId());
		
		int value = 0;
		
		if (instance.getCurRound() != 6) {
			ArrayList<Integer> v = new ArrayList<Integer>();
			for (int i : diceValues) {
				v.add(i);
			}
			value = RULES[instance.getCurRound()].calculate(v);
		}
		else {
			var v = new ArrayList<Integer>();
			int[] scores = score.getScoresAsArray();
			for (int i = 0; i < 6; i++) {
				v.add(scores[i]);
			}
			
			value = RULES[instance.getCurRound()].calculate(v);
		}
		
		score.setValue(instance.getCurRound(), value);
		
		playerDao.saveScoreCard(score);
		
		return value;
	}
	
}
