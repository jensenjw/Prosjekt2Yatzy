package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.json.LobbyListEntry;
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
		
		if (!sessionUtil.isLoggedIn(req)) {
			System.out.println("Not Logged In");
			resp.sendRedirect("/YatzySupreme");
			return;
		}
		
		List<LobbyListEntry> entries = lobbyService.getLobbyList();
		
		req.setAttribute("lobbies", entries);
		
		getServletContext().getRequestDispatcher("/WEB-INF/LobbyList.jsp").forward(req, resp);	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (!sessionUtil.isLoggedIn(req)) {
			System.out.println("Not Logged In");
			resp.sendRedirect("/YatzySupreme");
			return;
		}
		
		Player player = sessionUtil.getPlayer(req);
	
		if (player == null) {
			System.out.println("Not Logged In");
			resp.sendRedirect("/YatzySupreme");
			return;
		}
		
		OptionalInt curLobby = playerDao.getCurrentLobbyIdForPlayer(player);
		
		if (curLobby.isPresent()) {
			resp.sendRedirect("WaitRoom");
			return;
		}
	
		String gameId = req.getParameter("gameId");
		
		if (gameId == null) {
			resp.sendRedirect("/YatzySupreme/Html/MenuPage.html");
		}
		
		Lobby created = lobbyService.createLobby(gameId, player);
		
		if (created == null) {
			resp.sendRedirect("Lobby");
		}
		else {
			resp.sendRedirect("WaitRoom");
		}
		
		
	}
}
