package no.hvl.dat109.proj2.yatzy.entities;

public class GameInstance {
	private int curThrow;
	private int curRound;
	private int curPlayer;
	private int lobbyId;
	
	private int[] players;
	
	private final Dice[] dices;
	
	public GameInstance(Lobby lobby, int[] players) {
		this.curThrow = 0;
		this.curRound = 0;
		this.curPlayer = 0;
		this.lobbyId = lobby.getId();
		dices = new Dice[] {
				new Dice(),
				new Dice(),
				new Dice(),
				new Dice(),
				new Dice(),
		};
		this.players = players;
	}

	public void nextPlayer() {
		if (curPlayer >= players.length-1) {
			curPlayer = 0;
			curRound++;
		}
		else {
			curPlayer++;
		}
		curThrow = 0;
	}
	
	public int getCurPlayerId() {
		return players[curPlayer];
	}
	
	public int getCurThrow() {
		return curThrow;
	}

	public void setCurThrow(int curThrow) {
		this.curThrow = curThrow;
	}

	public int getCurRound() {
		return curRound;
	}

	public void setCurRound(int curRound) {
		this.curRound = curRound;
	}

	public int getCurPlayer() {
		return curPlayer;
	}

	public void setCurPlayer(int curPlayer) {
		this.curPlayer = curPlayer;
	}

	public int getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(int lobbyId) {
		this.lobbyId = lobbyId;
	}

	public Dice[] getDices() {
		return dices;
	}	
}
