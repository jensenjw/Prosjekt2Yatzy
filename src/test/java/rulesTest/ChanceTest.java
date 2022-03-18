package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleChance;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class ChanceTest {
	private static final RulesADT rules = new RuleChance();
	
	@Test
	public void chance_return15() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 3, 4, 5);
		
		//Act
		int sum = rules.calculate(dices);
		
		//Assert
		assertEquals(15, sum);
	}
}
