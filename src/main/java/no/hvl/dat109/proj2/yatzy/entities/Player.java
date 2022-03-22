package no.hvl.dat109.proj2.yatzy.entities;

/**
 * 
 * @author Eric 
 * Player klassen er et spiller objekt
 */

public class Player {

	int playerId; // tregner ikke genere noe verdi for den databasen gjør det selv, bare ha get og set id metodene
	String username;
	String password;
	String name;
	String email;
	int lobbyId;
	int warnings = 0;
	Score score; 

	/**
	 * @param playerId er iden på hvilken spiller dette er, altså 1,2,3 eller 4 f.eks
	 * @param username er bruker navnet til spilleren
	 * @param password passordet som brukeren lager for å kunne logge inn
	 * @param name     navnet på personen som lagde brukeren
	 * @param email    er e-post til spilleren
	 * @param lobbyId  er id til lobbyen som spilleren er i
	 * @param warning  er antall purringer eller annmerkinger en bruker kan ha før
	 *                 den blir kastet ut av en lobby
	 *  @param score er spillerens poengkort
	 */

	
	public Player () {
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLobbyId() {
		return lobbyId;
	}

	public void setLobbyId(int lobbyId) {
		this.lobbyId = lobbyId;
	}

	public Player(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.score = new Score();		

	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public int getId() {
		return playerId;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWarning() {
		return warnings;
	}
	
	

}
