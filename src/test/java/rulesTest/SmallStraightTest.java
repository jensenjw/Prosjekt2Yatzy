package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleSmallStraight;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class SmallStraightTest {

private static final RulesADT sStraight = new RuleSmallStraight();
	
	@Test
	public void SmallStraight_false() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 3, 4, 6);
		
		//Act
		int sum = sStraight.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
	@Test
	public void SmallStraight_True() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 3, 4, 5);
		
		//Act
		int sum = sStraight.calculate(dices);
		
		//Assert
		assertEquals(15, sum);
	}
}
