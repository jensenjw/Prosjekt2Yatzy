package no.hvl.dat109.proj2.yatzy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import no.hvl.dat109.proj2.yatzy.daos.LobbyDAO;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.json.LobbyListEntry;

@Stateful
public class LobbyService {
	
	
	@EJB
	private LobbyDAO lobbyDao;
	
	
	public LobbyService(){
		
	}
	
	
	public Optional<Lobby> tryGetLobby(String gameId){
		Lobby lobby = lobbyDao.getLobbyWithGameId(gameId);
		return lobby != null ? Optional.of(lobby) : Optional.empty();
	}
	
	
	
	public List<LobbyListEntry> getLobbyList() {
		return lobbyDao.getAllLobbies().stream().map(x -> new LobbyListEntry(x.getGameName(), x)).collect(Collectors.toList());
	}
	
	public Lobby createLobby(String gameId, Player owner) {
		if (tryGetLobby(gameId).isPresent()) {
			return null;
		}
		else {
			Lobby lobby = new Lobby();
			lobby.setOwner(owner.getId());
			lobby.setPlayers(new ArrayList<Player>());
			lobbyDao.tryCreateLobby(lobby);
			return lobby;
		}
	}
}
