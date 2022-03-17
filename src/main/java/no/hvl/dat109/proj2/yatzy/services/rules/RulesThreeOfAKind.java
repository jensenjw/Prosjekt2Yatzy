package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author janwi
 *	returns score if three of a kind exists
 */
public class RulesThreeOfAKind implements RulesADT {

	@Override
	public int calculate(List<Integer> list) {

		HashMap<Integer,Integer>map = new HashMap<Integer, Integer>();
		
		for(int i = 1;i < 7;i++) {
			map.put(i, 0);
		}
		for (Integer i : list) {
	        map.put(i, map.get(i)+1);
	    }
		for(int i = 6; i > 0; i--) {
			if(map.get(i)>=3) {
				return 3*i;
			}
		}
		return 0;
	}
}
