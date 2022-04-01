package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.services.LobbyService;
import no.hvl.dat109.proj2.yatzy.services.SessionUtil;

public class LobbyServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private LobbyService lobbyService;
	
	@EJB 
	private PlayerDAO playerDao;
	
	@EJB
	private SessionUtil sessionUtil;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (sessionUtil.isLoggedIn(req)) {
			resp.sendRedirect("");
			return;
		}
		
		String username = sessionUtil.getPlayerName(req);
		if (sessionUtil.getCurrentGameId(req) != null) {
			resp.sendRedirect("Lobby");
			return;
		}
		
		String gameId = req.getParameter("gameId");
		
		//TODO: redirect the username is invalid
		Player player = playerDao.findPlayerWithUsername(username).get();
		
		Lobby created = lobbyService.createLobby(gameId, player);
		
		if (created == null) {
			resp.sendRedirect("Lobby");
		}
		else {
			sessionUtil.setCurrentGameId(req, gameId);
			
		}
		
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
