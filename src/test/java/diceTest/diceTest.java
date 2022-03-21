package diceTest;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.entities.Dice;

public class diceTest {


	@Test
	public void testDiceValuesInRange() {
		
		//Arrange
		Dice dice = new Dice();
		
		//Act
		int roll = dice.rollDice();
		
		//Assert
		assertTrue(roll <= 6 && roll >= 1);
		
	}
	
}


