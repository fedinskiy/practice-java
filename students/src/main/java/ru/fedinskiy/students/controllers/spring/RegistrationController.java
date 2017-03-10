package ru.fedinskiy.students.controllers.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedinskiy.students.controllers.servlets.RegistrationServlet;
import ru.fedinskiy.students.exception.UserDAOException;
import ru.fedinskiy.students.services.UserService;

/**
 * Created by fedinskiy on 08.03.17.
 */
@Controller
public class RegistrationController {
	private static Logger logger = LogManager.getLogger(RegistrationServlet.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(){
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registry(@RequestParam(name = "login") String login,
	                       @RequestParam(name = "login") String password){
		try {
			if(userService.RegisterUser(login,password)){
				return ControllerUtils.redirectTo("login");
			}else{
				return ControllerUtils.redirectTo("error.jsp");
			}
		} catch (UserDAOException e) {
			logger.error(e);
			return ControllerUtils.redirectTo("error.jsp");
		}
	}
	
}
