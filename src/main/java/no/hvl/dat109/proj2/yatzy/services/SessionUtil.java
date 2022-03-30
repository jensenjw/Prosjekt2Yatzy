package no.hvl.dat109.proj2.yatzy.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	
	public String getCurrentGameId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		return session != null ? (String)session.getAttribute("gameId") : null;
	}
	
}
