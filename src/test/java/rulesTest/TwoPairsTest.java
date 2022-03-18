package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleTwoPair;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class TwoPairsTest {

private static final RulesADT twoPair = new RuleTwoPair();
	
	@Test
	public void TwoPair_NoPair_Return0() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 3, 4, 5);
		
		//Act
		int sum = twoPair.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void OnePair_Pair1_Return2() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 1, 3, 3, 5);
		
		//Act
		int sum = twoPair.calculate(dices);
		
		//Assert
		assertEquals(8, sum);
	}
}
