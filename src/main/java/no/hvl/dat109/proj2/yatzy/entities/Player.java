package no.hvl.dat109.proj2.yatzy.entities;

/**
 * 
 * @author Eric 
 * Player klassen er et spiller objekt
 */

public class Player {

	int id; // tregner ikke genere noe verdi for den databasen gjør det selv, bare ha get og set id metodene
	String username;
	String password;
	String name;
	int warning = 0;
	Score score; 

	/**
	 * @param id er iden på hvilken spiller dette er, altså 1,2,3 eller 4 f.eks
	 * @param username er bruker navnet til spilleren
	 * @param password passordet som brukeren lager for å kunne logge inn
	 * @param name     navnet på personen som lagde brukeren
	 * @param warning  er antall purringer eller annmerkinger en bruker kan ha før
	 *                 den blir kastet ut av en lobby
	 *  @param score er spillerens poengkort
	 */

	
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
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return warning;
	}
	
	

}
