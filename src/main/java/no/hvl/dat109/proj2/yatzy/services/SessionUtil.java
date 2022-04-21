package no.hvl.dat109.proj2.yatzy.services;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.proj2.yatzy.entities.Dice;
import no.hvl.dat109.proj2.yatzy.entities.Player;

@Stateless
public class SessionUtil {
	
	public boolean isLoggedIn(HttpServletRequest request) {
		return request.getSession(false) != null;
	}
	
	public Dice[] getOrCreateDices(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return null;
		}
		
		if (session.getAttribute("dices") == null) {
			session.setAttribute("dices", new Dice[] {
					new Dice(),
					new Dice(),
					new Dice(),
					new Dice(),
					new Dice()
			});
		}
		
		return (Dice[])session.getAttribute("dices");
	}
	
	public String getCurrentGameId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		return session != null ? (String)session.getAttribute("gameId") : null;
	}
	
	public Player getPlayer(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		return session != null ? (Player)session.getAttribute("player") : null;
	}
	
	public void setCurrentGameId(HttpServletRequest request, String gameId) {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.setAttribute("gameId", gameId);
		}
	}
}
