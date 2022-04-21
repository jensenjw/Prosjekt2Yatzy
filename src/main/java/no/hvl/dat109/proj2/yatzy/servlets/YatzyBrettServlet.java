package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.proj2.yatzy.daos.LobbyDAO;
import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.GameAssosiation;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.services.LobbyService;
import no.hvl.dat109.proj2.yatzy.services.SessionUtil;

/**
 * Servlet implementation class YatzyBrettServlet
 */
public class YatzyBrettServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private SessionUtil sessionUtil;
	
	@EJB
	private PlayerDAO playerDao;
	
	@EJB
	private LobbyService lobbyService;
	
	@EJB
	private LobbyDAO lobbyDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YatzyBrettServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO: det må assosieres et spill med en bruker,
	
		Player player = sessionUtil.getPlayer(request);
		if (player == null) {
			response.sendRedirect("/YatzySupreme/");
		}
		
		OptionalInt lobbyId = playerDao.getCurrentLobbyIdForPlayer(sessionUtil.getPlayer(request));
		
		String gameId = sessionUtil.getCurrentGameId(request);
		
		if (lobbyId.isEmpty()) {
			response.encodeRedirectURL("/YatzySupreme/Html/MenuPage.html");
		}
		else {
			List<GameAssosiation> players = lobbyDao.GetAllGameAssosiations(lobbyService.getLobby(lobbyId.getAsInt()));
			
			request.setAttribute("players",players.stream().map(x -> playerDao.get(x.getPlayerId()).getUsername()).collect(Collectors.toList()));
			
			
			getServletContext().getRequestDispatcher("/WEB-INF/YatzyBrett.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.encodeRedirectURL("/YatzyBrettServlet");
	}

}
