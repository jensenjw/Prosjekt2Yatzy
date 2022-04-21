package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import no.hvl.dat109.proj2.yatzy.daos.LobbyDAO;
import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.GameAssosiation;
import no.hvl.dat109.proj2.yatzy.entities.Lobby;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.json.WaitRoomPollJson;
import no.hvl.dat109.proj2.yatzy.services.GameLogicService;
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
	
	@EJB
	private LobbyDAO lobbyDao;
	
	@EJB 
	private PlayerDAO playerDao;
	
	@EJB
	private GameLogicService gameLogic;
	
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
		
		Player player = sessionUtil.getPlayer(request);
		
		if (player == null) {
			response.sendRedirect("/YatzySupreme");
			return;
		}
		request.getParameterNames().asIterator().forEachRemaining(x -> System.out.println(x));
		String gameId = request.getParameter("name");
		
		OptionalInt lobbyId = playerDao.getCurrentLobbyIdForPlayer(player);
		
		if (lobbyId.isPresent()) {
			Lobby lobby = lobbyService.getLobby(lobbyId.getAsInt());
			request.setAttribute("lobby", lobby); 
			getServletContext().getRequestDispatcher("/WEB-INF/WaitRoom.jsp").forward(request, response);
			System.out.println("User Already part of an room, they must leave first");
			return;	
		}
		
		Optional<Lobby> lobby = lobbyService.tryGetLobby(gameId);
		
		if (lobby.isEmpty()) {
			System.out.println("Invalid gameId: " + gameId);
			response.sendRedirect("/YatzySupreme/Html/MenuPage.html");
			return;
		}
		
		request.setAttribute("lobby", lobby.get());
		
		lobbyService.addPlayerToLobby(player, lobby.get());
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
		
		Player player = sessionUtil.getPlayer(request);
		
		System.out.println(player);
		
		if (player == null) {
			response.setStatus(401);
			response.getWriter().write("Unauthorized");
			return;
		}
		

		OptionalInt lobbyId = playerDao.getCurrentLobbyIdForPlayer(player);
		if (lobbyId.isEmpty()) {
			response.setStatus(404);
			response.getWriter().write("Invalid lobby");
			return;
		
		}
		
		
		Lobby lobby = lobbyService.getLobby(lobbyId.getAsInt());
		
		
		//Returnerer Bad Request hvis det ikke er noen act parameter
		String act = request.getParameter("act");
		if (act == null) {
			response.setStatus(400);
			return;
		}
		
		if (act.equals("poll")) {
			//POLL
			WaitRoomPollJson pollData = lobbyService.getPollData(lobby);
			
			String json = new Gson().toJson(pollData);
			
			response.setStatus(200);
			response.getWriter().write(json);
			return;
		}
		else if (act.equals("leave")) {
			lobbyService.removePlayerFromLobby(player, lobby);
			response.sendRedirect("/YatzySupreme/Html/MenuPage.html");
		}
		else if (act.equals("start")) {
			lobby.setCurRound(0);
			lobby.setCurPlayer(0);
			lobbyDao.updateLobby(lobby);
			List<GameAssosiation> players = lobbyDao.GetAllGameAssosiations(lobby);
			
			for (GameAssosiation p : players) {
				playerDao.createScoreCard(p.getPlayerId());
				
			}
			int[] idArr = players.stream().mapToInt(x -> x.getPlayerId()).toArray();
			
			gameLogic.createInstance(lobby, idArr);
			
			System.out.println("GameRoom Created");
			
			response.sendRedirect("YatzyBrettServlet");
		}
		else {
			
		}
	}

}
