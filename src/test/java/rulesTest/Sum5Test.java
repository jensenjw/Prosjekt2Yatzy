package rulesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleSum;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class Sum5Test {
	
	private static final RulesADT sumRule = new RuleSum(5);
	
	@Test
	public void RuleSum_3Fives_Returns15() {
		
		//Arrange
		int[] dices = new int[] {5, 5, 5, 3, 1};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(15, sum);
	}
	
	@Test
	public void RuleSum_0Fives_Returns0() {
		
		//Arrange
		int[] dices = new int[] {4, 1, 3, 2, 6};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void RuleSum_5Fives_Returns25() {
		
		//Arrange
		int[] dices = new int[] {5, 5, 5, 5, 5};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(25, sum);
	}
}
