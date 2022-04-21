package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.List;

public class RuleBonus implements RulesADT {

	@Override
	public int calculate(List<Integer> diceValues) {
		
		int sum = 0;
		for (int i : diceValues) {
			sum += i;
		}
		
		return sum >= 63 ? 50 : 0;
	}

}
