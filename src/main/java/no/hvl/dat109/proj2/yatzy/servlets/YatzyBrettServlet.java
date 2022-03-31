package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.proj2.yatzy.services.SessionUtil;

/**
 * Servlet implementation class YatzyBrettServlet
 */
public class YatzyBrettServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private SessionUtil sessionUtil;
	
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
	
		String gameId = sessionUtil.getCurrentGameId(request);
		
		if (false) {
			response.encodeRedirectURL("/");
		}
		else {
			ArrayList<String> players = new ArrayList<String>();
			
			players.add("Geir");
			players.add("Knut");
			players.add("Kåre");
			
			request.setAttribute("players",players);
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
