package no.hvl.dat109.proj2.yatzy.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;

@Stateless
public class LobbyDAO {
	
	@PersistenceContext(name = "YatzyPU")
	private EntityManager em;
	
	
	public List<Lobby> getAllLobbies() {
		return em.createQuery("Select p from Lobby p", Lobby.class).getResultList();
	}
	
	public boolean tryCreateLobby(Lobby lobby) {
		try {
			em.persist(lobby);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public Lobby getLobbyWithGameId(String gameId) {
		return em.createQuery("Select p from Lobby p Where gameName == '" + gameId + "'", Lobby.class).getSingleResult();
	}
}
