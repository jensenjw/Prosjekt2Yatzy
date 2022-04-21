package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.List;

/**
 * 
 * @author janwi
 *	Uses ruleOnePair twice by removing the dices from the first pair
 */
public class RuleTwoPair extends RuleOnePair implements RulesADT {

	public int resolveTwoPair(List<Integer> list) {
		return super.calculate(list) + super.calculate(list);
	}

	
	@Override
	public int calculate(List<Integer> list) {
		return resolveTwoPair(list);
	}
}
