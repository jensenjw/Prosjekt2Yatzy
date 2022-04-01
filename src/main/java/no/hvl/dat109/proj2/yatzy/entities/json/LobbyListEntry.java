package no.hvl.dat109.proj2.yatzy.entities.json;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;

public class LobbyListEntry {
	private final String gameId;
	private final Lobby lobby;
	
	public LobbyListEntry(String gameId, Lobby lobby) {
		this.gameId = gameId;
		this.lobby = lobby;
	}

	public String getGameId() {
		return gameId;
	}

	public Lobby getLobby() {
		return lobby;
	}
}
