package no.hvl.dat109.proj2.yatzy.services;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Stateless
public class SessionUtil {
	
	public boolean isLoggedIn(HttpServletRequest request) {
		return request.getSession(false) != null;
	}
	
	public String getCurrentGameId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		return session != null ? (String)session.getAttribute("gameId") : null;
	}
	
	public String getPlayerName(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		return session != null ? (String)session.getAttribute("playerId") : null;
	}
	
	public void setCurrentGameId(HttpServletRequest request, String gameId) {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.setAttribute("gameId", gameId);
		}
	}
}
