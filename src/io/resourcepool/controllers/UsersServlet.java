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

import io.resourcepool.daos.UserDao;
import io.resourcepool.models.User;


@WebServlet("/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserDao userDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		List<User> users;
		if(id == null) {
			//TODO wrap dao result, it seems to return a mapped arrayList
			users = userDao.findAll();
		}
		else {
			users = new ArrayList<User>();
			users.add(userDao.findOne(Long.parseLong(id)));
		}
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/showUsers.jsp").forward(request, response);

	}

}