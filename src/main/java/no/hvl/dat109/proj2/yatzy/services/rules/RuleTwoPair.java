package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.List;

/**
 * 
 * @author janwi
 *	Uses ruleOnePair twice by removing the dices from the first pair
 */
public class RuleTwoPair extends RuleOnePair {

	public int resolveTwoPair(List<Integer> list) {
		return calculate(list) + calculate(list);
	}

}
