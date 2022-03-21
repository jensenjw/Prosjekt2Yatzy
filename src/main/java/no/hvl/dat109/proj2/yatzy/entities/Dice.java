package no.hvl.dat109.proj2.yatzy.entities;

public class Dice {

	int value;
	
	public int rollDice() {
		return (int) (Math.floor(Math.random() * 6) + 1);
	}
}
