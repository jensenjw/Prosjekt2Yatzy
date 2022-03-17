package no.hvl.dat109.proj2.yatzy.services.rules;

public class RuleSum implements RulesADT {

	private final int expectedDiceValue;
	
	public RuleSum(int expected) {
		this.expectedDiceValue = expected;
	}
	
	@Override
	public int calculate(int[] diceValues) {
		int sum = 0;
		for (int value : diceValues) {
			if (value == expectedDiceValue) {
				sum += value;
			}
		}
		
		return sum;
	}

}
