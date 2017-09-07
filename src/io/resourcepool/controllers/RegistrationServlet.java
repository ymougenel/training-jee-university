package io.resourcepool.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.resourcepool.daos.AdressDao;
import io.resourcepool.daos.CellphoneDao;
import io.resourcepool.daos.UserDao;
import io.resourcepool.models.Adress;
import io.resourcepool.models.Cellphone;
import io.resourcepool.models.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserDao userDao;
	
	@Inject
	private AdressDao adresseDao;
	
	@Inject
	private CellphoneDao cellphoneDao;
	
	
	public RegistrationServlet() {
	}
	
	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("liveUserCount", userDao.count());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = parseUser(req);
		req.getSession().setAttribute("user", user);
		List<Adress> adresses= parseAdresses(req);
		for (Adress adresse : adresses) {
			adresseDao.save(adresse);
		}
		user.setAdresse(adresses);
		incrementLiveUserCount();
		userDao.save(user);
		resp.sendRedirect("dashboard");
	}
	
	private User parseUser(HttpServletRequest req) {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		
		return new User(firstName, lastName);
	}
	
	private List<Adress> parseAdresses(HttpServletRequest req) {
		String adresse = req.getParameter("adresse_domicile");
		String adressePro = req.getParameter("adresse_pro");
		List<Adress> adresses = new ArrayList<>();
		adresses.add(new Adress(adresse));
		adresses.add(new Adress(adressePro));

		return adresses;
	}
	private void incrementLiveUserCount() {
		Long liveUserCount = (Long) getServletContext().getAttribute("liveUserCount");
		getServletContext().setAttribute("liveUserCount", liveUserCount + 1);
	}
}
