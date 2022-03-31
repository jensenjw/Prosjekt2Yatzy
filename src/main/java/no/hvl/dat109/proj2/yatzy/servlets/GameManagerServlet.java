package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import no.hvl.dat109.proj2.yatzy.entities.json.YatzySpillJson;

/**
 * Servlet implementation class GameManagerServlet
 */
public class GameManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		HashMap<String, ArrayList<Integer>> scores = new HashMap<String, ArrayList<Integer>>();

		ArrayList<Integer> geirScore = new ArrayList<Integer>();
		
		geirScore.add(1); //1
		geirScore.add(2); //2
		geirScore.add(3); //3
		geirScore.add(4); //4
		geirScore.add(5); //5
		geirScore.add(6); //6
		geirScore.add(7); //1 par
		geirScore.add(8); //2 par
		geirScore.add(9); //3 like
		geirScore.add(0); //4 like
		geirScore.add(-1); //liten
		geirScore.add(-1); //stor
		geirScore.add(-1); //sjanse
		geirScore.add(-1); //yatzy
		geirScore.add(-1); //sum
		
		scores.put("Geir", geirScore);
		scores.put("Knut", geirScore);
		scores.put("Kåre", geirScore);
		
		String json = new Gson().toJson(new YatzySpillJson(scores));
		
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
		
		doGet(request, response);
	}

}
