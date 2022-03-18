package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleYatzy;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class YatzyTest {

	
private static final RulesADT rules = new RuleYatzy();
	
	@Test
	public void Yatzy_false_return0() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 3, 4, 5);
		
		//Act
		int sum = rules.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void Yatzy_true_return50() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(2, 2, 2, 2, 2);
		
		//Act
		int sum = rules.calculate(dices);
		
		//Assert
		assertEquals(50, sum);
	}
}
