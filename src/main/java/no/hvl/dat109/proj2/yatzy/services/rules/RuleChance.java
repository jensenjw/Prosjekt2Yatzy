package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.List;
/**
 * 
 * @author janwi
 *	Sum of all dices
 */
public class RuleChance implements RulesADT {

	@Override
	public int calculate(List<Integer> list) {
		int score = 0;
		for (Integer i : list) {
			score = score + i;
		}
		return score;
	}

}
