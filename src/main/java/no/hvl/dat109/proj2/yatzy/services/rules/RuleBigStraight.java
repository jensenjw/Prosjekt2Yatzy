package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.List;

/**
 * 
 * @author janwi
 *	Returns score for a big straight
 */
public class RuleBigStraight implements RulesADT {

	@Override
	public int calculate(List<Integer> list) {
		int score = 0;
		for(int i = 2; i < 7; i++) {
			if(list.get(list.indexOf(i)) == i){
				score = score +1;
			}
			if(score >=5) {
				return 20;
			}
		}
		return 0;
		
	}

}
