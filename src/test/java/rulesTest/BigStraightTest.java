package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleBigStraight;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class BigStraightTest {

private static final RulesADT bigStraight = new RuleBigStraight();
	
	@Test
	public void BigStraight_NoBigStraight_Returns0() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 3, 5, 6);
		
		//Act
		int sum = bigStraight.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void BigStraight_BigStraight_Returns20() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(2, 3, 4, 5, 6);
		
		//Act
		int sum = bigStraight.calculate(dices);
		
		//Assert
		assertEquals(20, sum);
	}
}
