package rulesTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleSum;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class OnePairTest {
	
	private static final RulesADT onePair = new RuleOnePair();
	
	@Test
	public void OnePair_NoPair_Return0() {
		
		//Arrange
		int[] dices = new int[] {1, 2, 3, 4, 5};
		
		//Act
		int sum = onePair.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	
	@Test
	public void OnePair_Pair1_Return2() {
		
		//Arrange
		int[] dices = new int[] {1, 1, 3, 4, 5};
		
		//Act
		int sum = onePair.calculate(dices);
		
		//Assert
		assertEquals(2, sum);
	}
}
