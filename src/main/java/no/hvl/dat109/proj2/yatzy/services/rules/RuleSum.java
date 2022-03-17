package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.List;

public class RuleSum implements RulesADT {

	private final int expectedDiceValue;
	
	public RuleSum(int expected) {
		this.expectedDiceValue = expected;
	}
	
	@Override
	public int calculate(List<Integer> diceValues) {
		int sum = 0;
		for (int value : diceValues) {
			if (value == expectedDiceValue) {
				sum += value;
			}
		}
		
		return sum;
	}

}
