package no.hvl.dat109.proj2.yatzy.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Eric
 * Lobby er et objekt som holder på liste med spiller og seere
 */

@Entity
@Table(schema = "yatzy", name = "lobby")
public class Lobby {
	
	@Id
	@Column(name = "lobbyid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	@Column(name = "owner")
	Integer owner;
	
	@Column(name = "lobbyname")
	String lobbyName;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "lobby")
	List <Player> players;
	
	List <Player> viewers;
	
	/**
	 * @param id er id til lobbyene
	 * @param [] players er en list som holder på spiller
	 * @param [] viewers er liste som holder på seere  
	 */
	
	// tom konstruktør slik at vi kan bruke metodene i klassen
	
	public Lobby () {
		
	}

	public int getId() {
		return id;
	}

	public Integer getOwner() {
		return owner;
	}
	
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Player> getViewers() {
		return viewers;
	}

	public void setViewers(List<Player> viewers) {
		this.viewers = viewers;
	}


	public String getGameName() {
		return lobbyName;
	}

	public void setGameName(String gameName) {
		this.lobbyName = gameName;
	}

	public void setId(int id) {
		this.id = id;
	}
}
