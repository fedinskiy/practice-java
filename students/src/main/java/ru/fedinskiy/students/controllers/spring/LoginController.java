package ru.fedinskiy.students.controllers.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedinskiy.students.controllers.servlets.LoginServlet;
import ru.fedinskiy.students.exception.UserDAOException;
import ru.fedinskiy.students.models.pojo.Student;
import ru.fedinskiy.students.services.StudentService;
import ru.fedinskiy.students.services.UserService;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by fedinskiy on 06.03.17.
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	private static Logger logger = LogManager.getLogger(LoginServlet.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(){
		
		final Student studentById = studentService.getStudentById(1);
		logger.info(studentById.getName());
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String authorization(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password){
		try {
			if (userService.authorize(login, password)) {
				logger.trace("authorized");
				return ControllerUtils.redirectTo("list");
			} else {
				logger.trace("not authorized");
				return "login";
			}
		} catch (UserDAOException e) {
			logger.error(e);
			return "error";
		}
	}
	
}
