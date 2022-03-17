package diceTest;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;
import rulesTest.RuleThreeOfAKind;

public class diceTest {


	
	@Test
	public void testDiceIsNotHigherThan6() {
		
		//Arrange
		Dice dice = new Dice();
		
		//Act
		int roll = dice.rollDice();
		
		//Assert
		assertTrue(roll <= 6);
	}
	
	@Test 
	public void testDiceIsNotLowerThan1() {
		
		//Arrange
		Dice dice = new Dice();
		
		//Act
		int roll = dice.rollDice();
		
		//Assert
		assertTrue(roll >= 1);
		
		
	}

}
