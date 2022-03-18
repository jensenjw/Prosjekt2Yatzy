package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleOnePair;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class OnePairTest {
	
	private static final RulesADT onePair = new RuleOnePair();
	
	@Test
	public void OnePair_NoPair_Return0() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 3, 4, 5);
		
		//Act
		int sum = onePair.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void OnePair_Pair1_Return2() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 1, 3, 4, 5);
		
		//Act
		int sum = onePair.calculate(dices);
		
		//Assert
		assertEquals(2, sum);
	}
}
