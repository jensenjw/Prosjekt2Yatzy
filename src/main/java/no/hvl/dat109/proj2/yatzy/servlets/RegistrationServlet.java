package no.hvl.dat109.proj2.yatzy.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import localstorage.LocalStorage;
import no.hvl.dat109.proj2.yatzy.daos.PlayerDAO;
import no.hvl.dat109.proj2.yatzy.entities.Player;
import no.hvl.dat109.proj2.yatzy.services.Encryption;
import no.hvl.dat109.proj2.yatzy.services.ValidatorService;


@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PlayerDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ValidatorService validator = new ValidatorService();
		Encryption passUtil = new Encryption();
		boolean allowed = true;
		Player player = new Player();
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		session = request.getSession(true);
		
		String username = request.getParameter("username");
		if (username == null || !validator.validateUsername(username)) {
			allowed = false;
		} else {
			player.setUsername(username);
		}

		String fullName = request.getParameter("fullName");
		if (fullName == null || !validator.validateFullname(fullName)) {
			allowed = false;
		} else {
			player.setFullname(fullName);
		}

		String email = request.getParameter("email");
		if (email == null || !validator.validateEmail(email)) {
			allowed = false;
		} else {
			player.setEmail(email);
		}

		String passordrequest = request.getParameter("password");
		String passordrequest2 = request.getParameter("password2");
		String encrypted = "";
		if (passordrequest == null || passordrequest2 == null || !validator.validatePassword(passordrequest)) {
			allowed = false;
		} else if (!validator.equalPassword(passordrequest, passordrequest2)) {
			allowed = false;
		} else {
			try {
				encrypted = passUtil.encrypt(passordrequest);
			} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
				e.printStackTrace();
				player.setPassword(encrypted);
			}
		}

		if (allowed == false) {
			response.sendRedirect("Registration");
		} else {
			LocalStorage ls = new LocalStorage();
			ls.addPlayer(player);
			session.setAttribute("online", "true");
			request.setAttribute("player", player);
			request.getRequestDispatcher("").forward(request, response);
		}
	}
}
