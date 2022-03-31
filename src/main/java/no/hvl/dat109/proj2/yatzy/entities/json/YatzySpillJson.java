package no.hvl.dat109.proj2.yatzy.entities.json;

import java.util.ArrayList;
import java.util.HashMap;

public class YatzySpillJson {
	private final HashMap<String, ArrayList<Integer>> scores;
	
	public YatzySpillJson(HashMap<String, ArrayList<Integer>> scores) {
		this.scores = scores;
	}

	public HashMap<String, ArrayList<Integer>> getScores() {
		return scores;
	}
}
