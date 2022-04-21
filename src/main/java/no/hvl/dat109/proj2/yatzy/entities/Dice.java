package no.hvl.dat109.proj2.yatzy.entities;

public class Dice {

	int value;
	
	public int rollDice() {
		this.value = (int) (Math.floor(Math.random() * 6) + 1);
		return value;
	}
	
	public int getValue() {
		return value;
	}
}
