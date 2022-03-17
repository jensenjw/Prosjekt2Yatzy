package rulesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleSum;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class Sum3Test {
	private static final RulesADT sumRule = new RuleSum(3);
	
	@Test
	public void RuleSum_3Threes_Returns9() {
		
		//Arrange
		int[] dices = new int[] {6, 3, 3, 3, 1};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(9, sum);
	}
	
	@Test
	public void RuleSum_0Threes_Returns0() {
		
		//Arrange
		int[] dices = new int[] {4, 1, 5, 2, 6};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void RuleSum_5Threes_Returns15() {
		
		//Arrange
		int[] dices = new int[] {3, 3, 3, 3, 3};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(15, sum);
	}
}
