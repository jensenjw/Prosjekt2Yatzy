package no.hvl.dat109.proj2.yatzy.daos;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Henrik E
 *
 */


public class YatzyDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("registrationPU");
	
	/**
	 * 
	 * @param id
	 * @return Lobby - Lobby med samme ID som gitt i parameter
	 */
	
	
	public Lobby getGameLobbyOnID(int id) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			
			return em.find(Lobby.class,id);
			
		} finally {
			em.close();
		}	
	}
	
	/**
	 * 
	 * @param newLobby - Lobby som skal opprettes og legges til.
	 */
	
	public void addNewGameLobby(Lobby newLobby) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			em.persist(newLobby);
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if(tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		
	}
	
	/**
	 * 
	 * @param id - ID på Lobby som skal slettes
	 */
	
	public void deleteGameLobbyOnID(int id) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Lobby lobby = em.find(Lobby.class,id);
			em.remove(lobby);
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if(tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

}
