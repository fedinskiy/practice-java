package controllers;

import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by fedinskiy on 22.02.17.
 */
public class SpisokServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("myParam", "paramparam");
		
		ArrayList<User> userlist = new ArrayList<User>();
		
		userlist.add(new User("Name", 1));
		userlist.add(new User("Name2", 2));
		userlist.add(new User("Name3", 3));
		
		req.setAttribute("userlist", userlist);
		
		User user1 = new User("Sara Connor",3);
		req.setAttribute("user",user1);
		getServletContext().getRequestDispatcher("/spisok.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
