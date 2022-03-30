package localstorage;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;

public final class LocalStorage {

	static List<Player> playerlist = new ArrayList<Player>();
	static List<Lobby> lobbylist = new ArrayList<Lobby>();
	
	public LocalStorage() {
	}
	
	public void addPlayer(Player player) {
		playerlist.add(player);
	}
	
	public Player findPlayer(Player player) {
		return playerlist.get(playerlist.indexOf(player));
	}
	
	public void addLobby(Lobby lobby) {
		lobbylist.add(lobby);
	}

	public Lobby findLobby(int id) {
		return lobbylist.get(id);
	}
	public List<Player> getPlayerlist() {
		return playerlist;
	}

	public void setPlayerlist(List<Player> playerlist) {
		LocalStorage.playerlist = playerlist;
	}

	public List<Lobby> getLobbylist() {
		return lobbylist;
	}

	public void setLobbylist(List<Lobby> lobbylist) {
		LocalStorage.lobbylist = lobbylist;
	}
	
	
}
