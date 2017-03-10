package ru.fedinskiy.students.controllers.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.fedinskiy.students.exception.UserDAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class RegistrationServlet extends HttpServlet {
	private static Logger logger = LogManager.getLogger(RegistrationServlet.class);
	@Autowired
	private UserService userService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.trace("get Registration");
		req.getRequestDispatcher("/registration.jsp").forward(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.trace("post Registration");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		try {
			if(userService.RegisterUser(login,password)){
				resp.sendRedirect("login");
			}else{
				resp.sendRedirect("error.jsp");
			}
		} catch (UserDAOException e) {
			logger.error(e);
			resp.sendRedirect("error.jsp");
		}
		
	}
}
