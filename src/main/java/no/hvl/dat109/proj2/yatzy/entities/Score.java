package no.hvl.dat109.proj2.yatzy.entities;

import javax.persistence.Column;
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
@Table(schema = "yatzy", name = "scoreCard")
public class Score {
	
	@Id
	int playerId;
	
	@Column(name = "ones") int ones;
	
	@Column(name = "twos") int twos;
	
	@Column(name = "threes") int threes;
	
	@Column(name = "fours") int fours;
	
	@Column(name = "fives") int fives;
	
	@Column(name = "sixes") int sixes;
	
	@Column(name = "bonus") int bonus;
	
	@Column(name = "one_pair") int onePair;
	
	@Column(name = "two_pairs") int twoPair;
	
	@Column(name = "three_of_a_kind") int threeofAKind;
	
	@Column(name = "four_of_a_kind") int fourOfAKind;
	
	@Column(name = "small_straight") int smallStraight;
	
	@Column(name = "big_straight") int bigStraight;
	
	@Column(name = "full_house") int fullHouse;
	
	@Column(name = "chance") int chance;
	
	@Column(name = "yatzy") int yatzy;
	
	
	// oppretter poengkortet med lenge 15 kategorier
	public Score () {
		
	}
	
	public int[] getScoresAsArray() {
		return new int[] {
				ones,
				twos,
				threes,
				fours,
				fives,
				sixes,
				bonus,
				onePair,
				twoPair,
				threeofAKind,
				fourOfAKind,
				smallStraight,
				bigStraight,
				fullHouse,
				chance,
				yatzy
		};
	}
	
	public void setValue(int id, int value) {
		switch (id) {
		case 0: ones = value; break;
		case 1: twos = value; break;
		case 2: threes = value; break;
		case 3: fours = value; break;
		case 4: fives = value; break;
		case 5: sixes = value; break;
		case 6: bonus = value; break;
		case 7: onePair = value; break;
		case 8: twoPair = value; break;
		case 9: threeofAKind = value; break;
		case 10: fourOfAKind = value; break;
		case 11: smallStraight = value; break;
		case 12: bigStraight = value; break;
		case 13: fullHouse = value; break;
		case 14: chance = value; break;
		case 15: yatzy = value; break;
		default: throw new RuntimeException("Invalid id " + id);
		}
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getOnes() {
		return ones;
	}
	public void setOnes(int ones) {
		this.ones = ones;
	}
	public int getTwos() {
		return twos;
	}
	public void setTwos(int twos) {
		this.twos = twos;
	}
	public int getThrees() {
		return threes;
	}
	public void setThrees(int threes) {
		this.threes = threes;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getFives() {
		return fives;
	}
	public void setFives(int fives) {
		this.fives = fives;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getOnePair() {
		return onePair;
	}
	public void setOnePair(int onePair) {
		this.onePair = onePair;
	}
	public int getTwoPair() {
		return twoPair;
	}
	public void setTwoPair(int twoPair) {
		this.twoPair = twoPair;
	}
	public int getThreeofAKind() {
		return threeofAKind;
	}
	public void setThreeofAKind(int threeofAKind) {
		this.threeofAKind = threeofAKind;
	}
	public int getFourOfAKind() {
		return fourOfAKind;
	}
	public void setFourOfAKind(int fourOfAKind) {
		this.fourOfAKind = fourOfAKind;
	}
	public int getSmallStraight() {
		return smallStraight;
	}
	public void setSmallStraight(int smallStraight) {
		this.smallStraight = smallStraight;
	}
	public int getBigStraight() {
		return bigStraight;
	}
	public void setBigStraight(int bigStraight) {
		this.bigStraight = bigStraight;
	}
	public int getFullHouse() {
		return fullHouse;
	}
	public void setFullHouse(int fullHouse) {
		this.fullHouse = fullHouse;
	}
	public int getChance() {
		return chance;
	}
	public void setChance(int chance) {
		this.chance = chance;
	}
	public int getYatzy() {
		return yatzy;
	}
	public void setYatzy(int yatzy) {
		this.yatzy = yatzy;
	}
	
	
	
}
