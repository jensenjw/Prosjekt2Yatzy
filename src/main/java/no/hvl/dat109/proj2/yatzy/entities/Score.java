package no.hvl.dat109.proj2.yatzy.entities;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Eric
 * Score er et poengkort objekt
 */

@Entity
@Table(schema = "yatzy", name = "player")
public class Score {
	
	@Id
	int playerId;
	
	// Arraylist for poeng 
		int [] score;
	
	// navn for indexene i score tabellen
	public static final int ONES = 0;
	public static final int TOWS = 1;
	public static final int THREES = 2;
	public static final int FOURS = 3;
	public static final int FIVES = 4;
	public static final int SIXES = 5;
	
	public static final int ONE_COUPLE = 6;
	public static final int TWO_COUPLES = 7;
	public static final int THREE_OF_A_KIND = 8;
	public static final int FOUR_OF_A_KIND = 9;
	public static final int SMALL_STRAIGTH = 10;
	public static final int LARGE_STRAIGTH = 11;
	public static final int HOUSE = 12;
	public static final int CHANCE = 13;
	public static final int YATZY = 14;
	
	// oppretter poengkortet med lenge 15 kategorier
	public Score () {
		
		int [] score = new int [14];
	}
	
	
	public int[] getScore() {
		return score;
	}
	public void setScore(int[] score) {
		this.score = score;
	}
	
	
	
	
	

}
