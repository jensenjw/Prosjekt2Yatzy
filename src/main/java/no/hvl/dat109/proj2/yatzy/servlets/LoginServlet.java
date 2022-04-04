package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;
import java.util.Optional;

import no.hvl.dat109.proj2.yatzy.daos.*;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.services.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlayerDAO playerDAO;

	@EJB
	Encryption encryption;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * 
	 *      Handles errors and sends user back to the login-page
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Handle errors

		if (request.getParameter("errormessage") != null) {
			request.setAttribute("errormessage", "Invalid username and/or password. Try again");

		} else if (request.getParameter("timeoutmessage") != null) {
			request.setAttribute("timeoutmessage", "You have been inactive for too long, you will now be logged out");
		}

		request.getRequestDispatcher("webapp/FrontPage.html").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * 
	 * 
	 *      Reads username and password. Checks if the input-password equals the
	 *      password set by the user. If password and username is correct, sends the
	 *      user to "Yatzy-page" Else sends an errormessage.
	 * 
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("recieved " + username + " " + password);
		
		Optional<Player> player = playerDAO.findPlayerWithUsername(username);

		if (player.isPresent()) {

			Player playerInstance = player.get();

			boolean validated = false;
			try {
				validated = encryption.validatePassword(password, playerInstance.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (validated) {

				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(150);
				session.setAttribute("player", player);
				response.sendRedirect("Html/MenuPage.html");
				System.out.println("Fuck YAAAAS");
				
			} else {
				response.sendRedirect("?errormessage");
				System.out.println("Invalid credentials");
			}

		} else {
			System.out.println("Invalid user");
			response.sendRedirect("?errormessage");
		}

	}

}
