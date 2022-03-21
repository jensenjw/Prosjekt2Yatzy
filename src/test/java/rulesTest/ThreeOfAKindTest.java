package rulesTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesThreeOfAKind;

public class ThreeOfAKindTest {

	private static final RulesADT threeOfAKind = new RulesThreeOfAKind();

	@Test
	public void ThreeOfAKind_Set1_Return3() {
		
		//Arrange 
		List<Integer >dices = Arrays.asList(1, 1, 1, 5, 3);
		
		//Act
		int sum = threeOfAKind.calculate(dices);
		
		//Assert
		assertEquals(3,sum);
	}
	
	
	@Test
	public void ThreeOfAKind_NoSet_Return0() {
		
		//Arrange
		List<Integer >dices = Arrays.asList(1,2,3,4,5);
		
		//Act
		int sum = threeOfAKind.calculate(dices);
		
		//Assert
		assertEquals(0,sum);
		
	}
	
	@Test
	public void ThreeOfAKind_Set4_Return12() {
		
		//Arrange 
		List<Integer >dices = Arrays.asList(4, 4, 4, 6, 3);
		
		//Act
		int sum = threeOfAKind.calculate(dices);
		
		//Assert
		assertEquals(12,sum);
	}
	
	

}
