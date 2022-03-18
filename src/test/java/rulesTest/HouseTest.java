package rulesTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleHouse;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class HouseTest {

private static final RulesADT house = new RuleHouse();
	
	@Test
	public void RuleHouse_2and3_Returns13() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(2, 2, 3, 3, 3);
		
		//Act
		int sum = house.calculate(dices);
		
		//Assert
		assertEquals(13, sum);
	}
	@Test
	public void RuleHouse_noHouse_Returns0() {
		
		//Arrange
		List<Integer> dices = Arrays.asList(1, 2, 2, 3, 3);
		
		//Act
		int sum = house.calculate(dices);
		
		//Assert
		assertEquals(0, sum);
	}
}
