package no.hvl.dat109.proj2.yatzy.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.proj2.yatzy.entities.Player;

@Stateless
public class PlayerDAO {

	@PersistenceContext(name = "YatzyPU")
	private EntityManager em; 
	public PlayerDAO() {
		
	}
	
	public Player get(int id) {
		String query = "Select p from Player p where playerid =" + id; 
		return em.createQuery(query, Player.class).getSingleResult();
	}
	
	public List<Player> getAll(){
		return em.createQuery("Select p from Player p", Player.class).getResultList();
	}
	
	public void post(Player player) {
		em.persist(player);
	}
	
	public void delete(int id) {
		String query = "Delete p from Player p where playerid =" + id; 
		em.createQuery(query, Player.class).getSingleResult();
	}
}
