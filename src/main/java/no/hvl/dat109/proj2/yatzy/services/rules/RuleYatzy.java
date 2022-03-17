package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.List;

/**
 * 
 * @author janwi
 *	Returns 50 if Yatzy exists
 */
public class RuleYatzy implements RulesADT {

	@Override
	public int calculate(List<Integer> list) {
		for(int i : list) {
			if(list.get(i) != list.get(i+1)) {
				return 0;
			}
		}	
		return 50;
	}	
}
