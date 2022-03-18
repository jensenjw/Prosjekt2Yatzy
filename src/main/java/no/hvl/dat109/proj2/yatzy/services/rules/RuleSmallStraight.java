package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.List;
/**
 * 
 * @author janwi
 *	returns score from a small staright
 */
public class RuleSmallStraight implements RulesADT {

	@Override
	public int calculate(List<Integer> list) {
		int score = 0;
		for(int i = 1; i < 6; i++) {
			if(list.get(list.indexOf(i)) == i){
				score = score +1;
			}
			if(score >=5) {
				return 15;
			}
		}
		return 0;
		
	}

}
