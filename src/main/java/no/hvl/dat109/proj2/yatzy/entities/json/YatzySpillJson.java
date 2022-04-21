package no.hvl.dat109.proj2.yatzy.entities.json;

import java.util.ArrayList;
import java.util.HashMap;

public class YatzySpillJson {
	private final HashMap<String, ArrayList<Integer>> scores;
	private final String curPlayer;
	private final int curRound;
	public YatzySpillJson(HashMap<String, ArrayList<Integer>> scores, String curPlayer, int curRound) {
		this.scores = scores;
		this.curPlayer = curPlayer;
		this.curRound = curRound;
	}

	public HashMap<String, ArrayList<Integer>> getScores() {
		return scores;
	}
}
