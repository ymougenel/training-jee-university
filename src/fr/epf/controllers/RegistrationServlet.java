package fr.epf.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.daos.AdresseDao;
import fr.epf.daos.UserDao;
import fr.epf.models.Adresse;
import fr.epf.models.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserDao userDao;
	
	@Inject
	private AdresseDao adresseDao;
	
	public RegistrationServlet() {
	}
	
	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("liveUserCount", 0);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = parseUser(req);
		req.getSession().setAttribute("user", u);
		Adresse a = parseAdresse(req);
		adresseDao.save(a);
		u.setAdresse(a);
		incrementLiveUserCount();
		userDao.save(u);
		resp.sendRedirect("dashboard");
	}
	
	private User parseUser(HttpServletRequest req) {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String adresse = req.getParameter("adresse");
		String country = req.getParameter("country");
		
		return new User(firstName, lastName);
	}
	
	private Adresse parseAdresse(HttpServletRequest req) {
		String adresse = req.getParameter("adresse");
		String country = req.getParameter("country");
		
		return new Adresse(adresse, country);
	}
	private void incrementLiveUserCount() {
		Integer liveUserCount = (Integer) getServletContext().getAttribute("liveUserCount");
		getServletContext().setAttribute("liveUserCount", liveUserCount + 1);
	}
}
