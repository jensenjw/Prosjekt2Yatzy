package no.hvl.dat109.proj2.yatzy.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import no.hvl.dat109.proj2.yatzy.daos.LobbyDAO;
import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.GameAssosiation;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.json.LobbyListEntry;
import no.hvl.dat109.proj2.yatzy.entities.json.WaitRoomPollJson;

@Stateful
public class LobbyService {
	
	
	@EJB
	private LobbyDAO lobbyDao;
	
	@EJB
	private PlayerDAO playerDao;
	
	public LobbyService(){
		
	}
	
	public Lobby getLobby(int lobbyId) {
		return lobbyDao.getLobby(lobbyId);
	}
	
	public Optional<Lobby> tryGetLobby(String gameId){
		return lobbyDao.getLobbyWithGameId(gameId);
	}
	
	
	
	public List<LobbyListEntry> getLobbyList() {
		return lobbyDao.getAllLobbies().stream().map(x -> new LobbyListEntry(x.getLobbyName(), x)).collect(Collectors.toList());
	}
	
	public Lobby createLobby(String gameId, Player owner) {
		if (tryGetLobby(gameId).isPresent()) {
			return null;
		}
		else {
			Lobby lobby = new Lobby();
			lobby.setLobbyName(gameId);
			lobby.setOwner(owner.getId());
			lobby.setCurPlayer(-1);
			lobby.setCurRound(-1);
			
			System.out.println("Creating Lobby!!!!");
			if (!lobbyDao.tryCreateLobby(lobby)) {
				return null;
			}
			else {
				addPlayerToLobby(owner, lobby);
				return lobby;
			}
		}
	}
	
	public void addPlayerToLobby(Player player, Lobby lobby) {
		GameAssosiation assosiation = new GameAssosiation();
		assosiation.setLobbyId(lobby.getId());
		assosiation.setPlayerId(player.getId());
		lobbyDao.addGameAssosiation(assosiation);
	}
	
	public void removePlayerFromLobby(Player player, Lobby lobby) {
		Optional<GameAssosiation> assosiation = lobbyDao.GetGameAssosiationForPlayer(player);
		
		if (assosiation.isPresent()) {
			GameAssosiation gameAssosiation = assosiation.get();
			if (gameAssosiation.getLobbyId() == lobby.getId()) {
				lobbyDao.removeGameAssosiation(gameAssosiation);
			}
		}
		
		//Spilleren som forlot er admin
		if (lobby.getOwner() == player.getId()) {
			List<GameAssosiation> players = lobbyDao.GetAllGameAssosiations(lobby);
			players.sort((a,b) -> Integer.compare(a.getSequenceNumber(), b.getSequenceNumber()));
			
			//Hvis det ikke er noen igjen i rommet så sletter vi lobbyen
			//Ellers så endrer vi hvem som er eieren til nestemann i rekken
			if (players.size() == 0) {
				lobbyDao.DeleteLobby(lobby);
			}
			else {
				lobby.setOwner(players.get(0).getPlayerId());
				lobbyDao.updateLobby(lobby);
			}
		}
		
	}
	
	public WaitRoomPollJson getPollData(Lobby lobby) {
		Player owner = playerDao.get(lobby.getOwner());
		List<GameAssosiation> players = lobbyDao.GetAllGameAssosiations(lobby);
		
		String ownerName = owner.getUsername();
		List<String> playerNames = players.stream().map(x -> playerDao.get(x.getPlayerId()).getUsername()).collect(Collectors.toList());
		return new WaitRoomPollJson(ownerName, playerNames, lobby.getCurRound() >= 0);
	}
}
