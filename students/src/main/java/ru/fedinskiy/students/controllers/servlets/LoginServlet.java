package ru.fedinskiy.students.controllers.servlets;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.fedinskiy.students.exception.UserDAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fedinskiy.students.models.pojo.Student;
import ru.fedinskiy.students.services.StudentService;
import ru.fedinskiy.students.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fedinskiy on 23.02.17.
 */

public class LoginServlet extends HttpServlet {
	@Autowired
	private UserService userService;
	private static Logger logger = LogManager.getLogger(LoginServlet.class);
	private final String loginPath = "/login.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.trace("forward");
		req.getRequestDispatcher(loginPath).forward(req,resp);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("getting data");
		logger.trace("gettingData");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		try {
			if (userService.authorize(login, password)) {
				logger.trace("authorized");
				resp.sendRedirect("list");
			} else {
				logger.trace("not authorized");
				resp.sendRedirect("/login");
			}
		} catch (UserDAOException e) {
			logger.error(e);
			resp.sendRedirect("/error.jsp");
		}
	}
}
