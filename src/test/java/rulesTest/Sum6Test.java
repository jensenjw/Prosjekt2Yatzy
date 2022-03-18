package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleSum;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class Sum6Test {
	
	private static final RulesADT sumRule = new RuleSum(6);
	
	@Test
	public void RuleSum_3Six_Returns18() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(6, 3, 6, 6, 1);
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(18, sum);
	}
	
	@Test
	public void RuleSum_0Six_Returns0() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(4, 1, 5, 2, 3);
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void RuleSum_5Six_Returns30() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(6, 6, 6, 6, 6);
		
		//Act
		int sum = sumRule.calculate(dices);
		
		//Assert
		assertEquals(30, sum);
	}
}
