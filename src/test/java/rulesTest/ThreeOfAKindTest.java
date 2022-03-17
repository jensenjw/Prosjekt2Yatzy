package rulesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class ThreeOfAKindTest {

	private static final RulesADT threeOfAKind = new RuleThreeOfAKind();

	@Test
	public void ThreeOfAKind_Set1_Return3() {
		
		//Arrange 
		int[] dices = new int[] {1, 1, 1, 5, 3};
		
		//Act
		int sum = threeOfAKind.calculate(dices);
		
		//Assert
		assertEquals(3,sum);
	}
	
	
	@Test
	public void ThreeOfAKind_NoSet_Return0() {
		
		//Arrange
		int[] dices = new int[] {1,2,3,4,5};
		
		//Act
		int sum = threeOfAKind.calculate(dices);
		
		//Assert
		assertEquals(0,sum);
		
	}
	
	@Test
	public void ThreeOfAKind_Set4_Return12() {
		
		//Arrange 
		int[] dices = new int[] {4, 4, 4, 6, 3};
		
		//Act
		int sum = threeOfAKind.calculate(dices);
		
		//Assert
		assertEquals(12,sum);
	}
	
	

}
