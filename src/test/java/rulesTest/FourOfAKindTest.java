package rulesTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import no.hvl.dat109.proj2.yatzy.services.rules.RuleFourOfAKind;
import no.hvl.dat109.proj2.yatzy.services.rules.RulesADT;

public class FourOfAKindTest {
	
	private static final RulesADT fourOfAKind = new RuleFourOfAKind();

	@Test
	public void FourOfAKind_Quad1_Return4() {
		
		//Arrange 
		List<Integer >dices = Arrays.asList(1, 1, 1, 1, 3);
		
		//Act
		int sum = fourOfAKind.calculate(dices);
		
		//Assert
		assertEquals(4,sum);
	}
	
	
	@Test
	public void FourOfAKind_NoQuads_Return0() {
		
		//Arrange
		List<Integer >dices = Arrays.asList(1,2,3,4,5);
		
		//Act
		int sum = fourOfAKind.calculate(dices);
		
		//Assert
		assertEquals(0,sum);
		
	}
	
	@Test
	public void FourOfAKind_Quad4_Return16() {
		
		//Arrange 
		List<Integer >dices = Arrays.asList(4, 4, 4, 4, 3);
		
		//Act
		int sum = fourOfAKind.calculate(dices);
		
		//Assert
		assertEquals(16,sum);
	}

}
