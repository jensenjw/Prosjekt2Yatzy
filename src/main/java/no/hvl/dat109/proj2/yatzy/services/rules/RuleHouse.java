package no.hvl.dat109.proj2.yatzy.services.rules;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author janwi
 *	Returns sum of house if it exists
 */
public class RuleHouse implements RulesADT {

	@Override
	public int calculate(List<Integer> list) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 1; i < 7; i++) {
			map.put(i, 0);
		}
		for (int i = 0; i < 6; i++) {
			if (list.get(i) == i) {
				map.put(list.get(i), map.get(i) + 1);
			}
		}
		int score = 0;
		for (int i = 6; i > 0; i--) {
			if (map.get(i) >= 3) {
				score = 3 * i;
				map.put(i, 0);
				for (int j = 6; j > 0; j--) {
					if (map.get(j) >= 2) {
						score = score + 2 * j;
						return score;
					}
				}

			}
		}
		return 0;
	}
}
