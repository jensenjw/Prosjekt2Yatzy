package no.hvl.dat109.proj2.yatzy.daos;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.proj2.yatzy.entities.GameAssosiation;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;

@Stateless
public class LobbyDAO {
	
	@PersistenceContext(name = "YatzyPU")
	private EntityManager em;
	
	
	public Lobby getLobby(int lobbyId) {
		return em.find(Lobby.class, lobbyId);
	}
	
	public List<Lobby> getAllLobbies() {
		return em.createQuery("Select p from Lobby p", Lobby.class).getResultList();
	}
	
	public boolean tryCreateLobby(Lobby lobby) {
		try {
			System.out.println("Persisting Lobby");
			em.persist(lobby);
			em.flush();
			System.out.println("Persisted Lobby");
			
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void updateLobby(Lobby lobby) {
		em.merge(lobby);
		em.flush();
	}
	
	public void DeleteLobby(Lobby lobby) {
		Lobby entry = em.merge(lobby);
		em.remove(entry);
		em.flush();
	}
	
	public Optional<Lobby> getLobbyWithGameId(String gameId) {
		List<Lobby> results = em.createQuery("Select p from Lobby p Where p.lobbyName = '" + gameId + "'", Lobby.class).getResultList();
		return results.size() > 0 ? Optional.of(results.get(0)) : Optional.empty();
	}
	
	public List<GameAssosiation> GetAllGameAssosiations(Lobby lobby){
		List<GameAssosiation> list = em.createQuery("Select s from GameAssosiation s Where s.lobbyId = " + lobby.getId(),GameAssosiation.class).getResultList();
		return list;
	}
	
	public Optional<GameAssosiation> GetGameAssosiationForPlayer(Player player){
		List<GameAssosiation> list = em.createQuery("Select s from GameAssosiation s Where s.playerId = " + player.getId(),GameAssosiation.class).getResultList();
		
		return list.size() > 0 ? Optional.of(list.get(0)) : Optional.empty();
	}
	
	public void addGameAssosiation(GameAssosiation assosiation) {
		em.persist(assosiation);
		em.flush();
	}
	
	public void removeGameAssosiation(GameAssosiation assosiation) {
		em.remove(assosiation);
		em.flush();
	}
}
