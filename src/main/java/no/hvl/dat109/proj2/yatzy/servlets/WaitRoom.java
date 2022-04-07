package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.services.LobbyService;
import no.hvl.dat109.proj2.yatzy.services.SessionUtil;

/**
 * Servlet implementation class WaitRoom
 */
public class WaitRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private SessionUtil sessionUtil;
	
	
	@EJB
	private LobbyService lobbyService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaitRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!sessionUtil.isLoggedIn(request)) {
			response.sendRedirect("/YatzySupreme");
			return;
		}
		
		String gameId = sessionUtil.getCurrentGameId(request);
		if (gameId == null) {
			response.sendRedirect("/Html/MenuPage.html");
			return;	
		}
		
		Optional<Lobby> lobby = lobbyService.tryGetLobby(gameId);
		if (lobby.isEmpty()) {
			sessionUtil.setCurrentGameId(request, null);
			response.sendRedirect("/Html/MenuPage.html");
			return;
		}
		
		request.setAttribute("lobby", lobby);
		getServletContext().getRequestDispatcher("/WEB-INF/WaitRoom.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Returnerer Unauthorized hvis brukeren ikke er logget inn
		if (!sessionUtil.isLoggedIn(request)) {
			response.setStatus(401);
			response.getWriter().write("Unauthorized");
			return;
		}
		
		
		//Returnerer Not Found Hvis Brukeren ikke er del av en lobby eller et spill
		String gameId = sessionUtil.getCurrentGameId(request);
		if (gameId == null) {	
			response.setStatus(404);
			response.getWriter().write("No Game Id");
			return;
		}
		
		//Returnerer Bad Request hvis det ikke er noen act parameter
		String act = request.getParameter("act");
		if (act == null) {
			response.setStatus(400);
		}
		
		Optional<Lobby> lobby = lobbyService.tryGetLobby(gameId);
		
		if (lobby.isEmpty()) {
			sessionUtil.setCurrentGameId(request, null);
			response.setStatus(404);
			response.getWriter().write("No Invalid Game Id");
			return;
		}
		
		Lobby lobbyInstance = lobby.get();
		
		if (act.equals("poll")) {
			//POLL
		}
		else {
			
		}
	}

}
