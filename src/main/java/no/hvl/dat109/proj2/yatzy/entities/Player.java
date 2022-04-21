package no.hvl.dat109.proj2.yatzy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Eric 
 * Player klassen er et spiller objekt
 */
@Entity
@Table(schema = "yatzy", name ="player")
public class Player {


	@Id
	@Column(name = "playerid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerId; // tregner ikke genere noe verdi for den databasen gjør det selv, bare ha get og set id metodene
	
	@Column(name = "username")
	String username;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "name")
	String fullname;
	
	@Column(name = "email")
	String email;

	
	@Column(name = "warnings")
	int warnings = 0;
	
	
	//Score score; 

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
		this.playerId = 0;
		this.username = null;
		this.password = null;
		this.fullname = null;
		this.email = null;
		this.warnings = 0;
	}
	

	public Player(String username, String fullname, String email, String password) {
		this();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;

	}

	public int getWarning() {
		return warnings;
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


	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
  
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
