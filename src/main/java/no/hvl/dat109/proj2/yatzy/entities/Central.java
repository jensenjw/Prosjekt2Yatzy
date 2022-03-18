package no.hvl.dat109.proj2.yatzy.entities;

import java.util.List;

/**
 * 
 * @author Eric Central er et sentral objekt som oppretter liste med lobby og
 *         spillere som er opprettet.
 */

public class Central {

	List <Lobby> lobbyList;
	List <Player> playerList;
	
	Lobby lobby;
	Player player;

	/**
	 * @param lobbyList er en liste som holder på lobbyer som er opprettet
	 * @param playerList er en liste som holder på spiller som er opprettet
	 * @param lobbyId er id til det lobbyene som er opprettet
	 * @param playerId er id til det spillerene som er opprettet
	 */
	
	
	public Central() {
		this.lobbyList = lobbyList;
		this.playerList = playerList;
		this.lobby = new Lobby();
		this.player = new Player();
	}

	public List<Lobby> getLobbyList() {
		return lobbyList;
	}

	public void setLobbyList(List<Lobby> lobbyList) {
		this.lobbyList = lobbyList;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public Lobby getLobby() {
		return lobby;
	}

	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}


	
	
}
