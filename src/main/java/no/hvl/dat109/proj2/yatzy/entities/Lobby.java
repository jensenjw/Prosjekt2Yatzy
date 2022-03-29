package no.hvl.dat109.proj2.yatzy.entities;

import java.util.List;

/**
 * 
 * @author Eric
 * Lobby er et objekt som holder på liste med spiller og seere
 */

public class Lobby {
	
	public int id;
	public List <Player> players;
	public List <Player> viewers;
	
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




	
	

}
