package rulesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class FourOfAKindTest {
	
	private static final RulesADT fourOfAKind = new RuleFourOfAKind();

	@Test
	public void FourOfAKind_Quad1_Return4() {
		
		//Arrange 
		int[] dices = new int[] {1, 1, 1, 1, 3};
		
		//Act
		int sum = fourOfAKind.calculate(dices);
		
		//Assert
		assertEquals(4,sum);
	}
	
	
	@Test
	public void FourOfAKind_NoQuads_Return0() {
		
		//Arrange
		int[] dices = new int[] {1,2,3,4,5};
		
		//Act
		int sum = fourOfAKind.calculate(dices);
		
		//Assert
		assertEquals(0,sum);
		
	}
	
	@Test
	public void FourOfAKind_Quad4_Return16() {
		
		//Arrange 
		int[] dices = new int[] {4, 4, 4, 4, 3};
		
		//Act
		int sum = fourOfAKind.calculate(dices);
		
		//Assert
		assertEquals(16,sum);
	}

}
