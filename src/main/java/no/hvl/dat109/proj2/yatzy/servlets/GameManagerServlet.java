package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalInt;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import no.hvl.dat109.proj2.yatzy.daos.LobbyDAO;
import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.Dice;
import no.hvl.dat109.proj2.yatzy.entities.GameAssosiation;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.entities.Score;
import no.hvl.dat109.proj2.yatzy.entities.json.RollJson;
import no.hvl.dat109.proj2.yatzy.entities.json.RollResponseJson;
import no.hvl.dat109.proj2.yatzy.entities.json.YatzySpillJson;
import no.hvl.dat109.proj2.yatzy.services.GameLogicService;
import no.hvl.dat109.proj2.yatzy.services.LobbyService;
import no.hvl.dat109.proj2.yatzy.services.SessionUtil;

/**
 * Servlet implementation class GameManagerServlet
 */
public class GameManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB private SessionUtil sessionUtil;
	
	@EJB private PlayerDAO playerDao;
	
	@EJB private LobbyService lobbyService;
	
	@EJB private LobbyDAO lobbyDao;
	
	@EJB private GameLogicService gameLogic;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Api endepunkt for å hente informasjon om et pågående spill
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Player player = sessionUtil.getPlayer(request);
		
		if (player == null) {
			response.setStatus(401);
			return;
		}
		
		OptionalInt lobby = playerDao.getCurrentLobbyIdForPlayer(player);
		
		if (lobby.isEmpty()) {
			response.setStatus(404);
			response.getWriter().print("Invalid Lobby Id");
			return;
		}
		
		
		HashMap<String, ArrayList<Integer>> scores = new HashMap<String, ArrayList<Integer>>();
		
		var lobbyObj = lobbyDao.getLobby(lobby.getAsInt());
		
		List<GameAssosiation> players = lobbyDao.GetAllGameAssosiations(lobbyObj);
		
		for (GameAssosiation ga : players) {
			Player p = playerDao.get(ga.getPlayerId());
			Score s = playerDao.getScoreCard(p.getId());
			
			ArrayList<Integer> scoreArray = new ArrayList<Integer>();
			for (final int i : s.getScoresAsArray()) {
				scoreArray.add(i);
			}
			scores.put(p.getUsername(), scoreArray);
		}
		
		String json = new Gson().toJson(new YatzySpillJson(scores, gameLogic.getPlayerName(lobbyObj),gameLogic.getCurrentRound(lobbyObj)));
		
		response.getWriter().print(json);
		response.setContentType("application/json");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Api endepunkt for å utføre en handling på et pågående spill
	 * Skal kodes ved hjelp av et queryparameter som sier hvilken handlinger en spiller ønsker å gjøre
	 * samt ekstra parametere
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		if (act != null) {
			if (act.equals("roll")) {
				
				RollJson roll = new Gson().fromJson(request.getReader(), RollJson.class);
				var lobbyId = playerDao.getCurrentLobbyIdForPlayer(sessionUtil.getPlayer(request));
				var lobby = lobbyDao.getLobby(lobbyId.getAsInt());
				var player =  sessionUtil.getPlayer(request);
				
				System.out.println("starting roll for " + player.getUsername());
				
				System.out.println("dices to keep :" + Arrays.toString(roll.getKeep()));
				
				int[] values = gameLogic.throwDices(lobby, sessionUtil.getPlayer(request), roll.getKeep());
				
				if (values == null) {
					//Wrong player
					response.getWriter().write(new Gson().toJson(new RollResponseJson(new int[] {0,0,0,0,0})));
					return;
				}
				
				if(gameLogic.playerDone(lobby, player)) {
					System.out.println(player.getUsername() + " done, continuing");
					gameLogic.getScore(lobby, player, values);
					gameLogic.nextPlayer(lobby);
				}
				
				response.getWriter().write(new Gson().toJson(new RollResponseJson(values)));
				//TODO roll logic
			}
			else {
				//TODO andre acts
			}
		}
	}

}
