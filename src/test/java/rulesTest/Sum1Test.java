package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleSum;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class Sum1Test {

	private static final RulesADT sumRule = new RuleSum(1);
	
	@Test
	public void RuleSum_3Ones_Returns3() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 1, 3, 1);
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(3, sum);
	}
	
	@Test
	public void RuleSum_0Ones_Returns0() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(4, 2, 5, 3, 6);
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void RuleSum_5Ones_Returns5() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 1, 1, 1, 1);
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(5, sum);
	}
}
