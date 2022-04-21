package no.hvl.dat109.proj2.yatzy.entities.json;

import java.util.List;

public class WaitRoomPollJson {
	String owner;
	List<String> players;
	boolean started;
	public WaitRoomPollJson(String owner, List<String> players, boolean started) {
		this.owner = owner;
		this.players = players;
		this.started = started;
	}
}
