package controllers;

import common.exception.UserDAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fedinskiy on 23.02.17.
 */
public class LoginServlet extends HttpServlet {
	private static Logger logger = LogManager.getLogger(LoginServlet.class);
	private final String loginPath = "/login.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.trace("forward");
		req.getRequestDispatcher(loginPath).forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("getting data");
		logger.trace("gettingData");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		try {
			if (UserService.authorize(login, password)) {
				logger.trace("authorized");
				resp.sendRedirect("/students/list");
			} else {
				//req.s("/login.jsp").forward(req, resp);
				logger.trace("not authorized");
				resp.sendRedirect("/students/login");
			}
		} catch (UserDAOException e) {
			logger.error(e);
			resp.sendRedirect("/error.jsp");
		}
	}
}
