package no.hvl.dat109.proj2.yatzy.daos;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.sessions.Login;
import org.eclipse.persistence.sessions.Session;

import no.hvl.dat109.proj2.yatzy.entities.GameAssosiation;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.Score;

@Stateless
public class PlayerDAO {

	@PersistenceContext(name = "YatzyPU")
	private EntityManager em;
	public PlayerDAO() {
		
	}
	
	public Player get(int playerId) {
		
//		String nq = "SELECT playerid, username from player";
//		return (Player) em.createNamedQuery(nq, Player.class).getSingleResult();
	//	String query = "Select p from Player p"; 
		//return em.createQuery(query, Player.class).getSingleResult();
		return em.find(Player.class, playerId);
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

	public boolean checkEmail(String email) {
		if((em.find(Player.class, email) != null)) {
			return true;
		}
			return false;
	}
	
	public Optional<Player> findPlayerWithUsername(String username){
		
		return getAll().stream().filter(x -> {
			return x.getUsername().equals(username);
		}).findFirst();
	}
	
	public OptionalInt getCurrentLobbyIdForPlayer(Player player){
		List<GameAssosiation> assosiations = em.createQuery("Select s from GameAssosiation s Where s.playerId = :id", GameAssosiation.class).setParameter("id", player.getId()).getResultList();
		return assosiations.size() > 0 ? OptionalInt.of(assosiations.get(0).getLobbyId()) : OptionalInt.empty();
	}
	
	public void createScoreCard(int playerId) {
		Score score = new Score();
		score.setPlayerId(playerId);
		score.setOnes(-1);
		score.setTwos(-1);
		score.setThrees(-1);
		score.setFours(-1);
		score.setFives(-1);
		score.setSixes(-1);
		score.setBonus(-1);
		score.setOnePair(-1);
		score.setTwoPair(-1);
		score.setThreeofAKind(-1);
		score.setFourOfAKind(-1);
		score.setSmallStraight(-1);
		score.setBigStraight(-1);
		score.setFullHouse(-1);
		score.setChance(-1);
		score.setYatzy(-1);
		
		em.persist(score);
		em.flush();
	}
	
	public Score getScoreCard(int playerId) {
		return em.createQuery("Select s from Score s Where s.playerId = :id", Score.class).setParameter("id", playerId).getSingleResult();
	}
	
	public void saveScoreCard(Score scoreCard) {
		em.merge(scoreCard);
		em.flush();
	}
}
