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
	
	@Column(name = "curPlayer")
	int curPlayer;
	
	@Column(name = "curRound")
	int curRound;

	
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


	public String getLobbyName() {
		return lobbyName;
	}

	public void setLobbyName(String gameName) {
		this.lobbyName = gameName;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCurPlayer() {
		return curPlayer;
	}

	public void setCurPlayer(int curPlayer) {
		this.curPlayer = curPlayer;
	}

	public int getCurRound() {
		return curRound;
	}

	public void setCurRound(int curRound) {
		this.curRound = curRound;
	}
}
