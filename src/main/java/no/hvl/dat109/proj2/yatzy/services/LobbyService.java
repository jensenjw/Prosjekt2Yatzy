package no.hvl.dat109.proj2.yatzy.services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.json.LobbyListEntry;

public class LobbyService {
	private ConcurrentHashMap<String, Lobby> lobbies;
	
	
	
	public LobbyService(){
		lobbies = new ConcurrentHashMap<String, Lobby>();
	}
	
	
	public Optional<Lobby> tryGetLobby(String gameId){
		if(lobbies.contains(gameId)) {
			return Optional.of(lobbies.get(gameId));
		}
		else {
			return Optional.empty();
		}
	}
	
	
	
	public ArrayList<LobbyListEntry> getLobbyList() {
		ArrayList<LobbyListEntry> entries = new ArrayList<LobbyListEntry>();
		lobbies.entrySet().forEach(x -> entries.add(new LobbyListEntry(x.getKey(), x.getValue())));
		return entries;
	}
	
	public Lobby createLobby(String gameId, Player owner) {
		if (tryGetLobby(gameId).isPresent()) {
			return null;
		}
		else {
			Lobby lobby = new Lobby();
			lobby.setOwner(owner);
			lobby.setPlayers(new ArrayList<Player>());
			lobbies.put(gameId, lobby);
			return lobby;
		}
	}
}
