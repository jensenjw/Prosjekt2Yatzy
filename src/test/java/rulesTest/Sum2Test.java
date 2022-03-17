package rulesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleSum;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class Sum2Test {
private static final RulesADT sumRule = new RuleSum(2);
	
	@Test
	public void RuleSum_3Twos_Returns6() {
		
		//Arrange
		int[] dices = new int[] {2, 2, 1, 3, 2};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(6, sum);
	}
	
	@Test
	public void RuleSum_0Twos_Returns0() {
		
		//Arrange
		int[] dices = new int[] {4, 1, 5, 3, 6};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void RuleSum_5Twos_Returns10() {
		
		//Arrange
		int[] dices = new int[] {2, 2, 2, 2, 2};
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(10, sum);
	}
}
