package no.hvl.dat109.proj2.yatzy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "yatzy", name = "gameAssosiation")
public class GameAssosiation {

	@Id
	@Column(name = "lobbyId")
	private int lobbyId;
	
	@Id
	@Column(name = "playerId")
	private int playerId;
	
	@Column(name = "sequenceNum")
	private int sequenceNumber;

	public int getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(int lobbyId) {
		this.lobbyId = lobbyId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
}
