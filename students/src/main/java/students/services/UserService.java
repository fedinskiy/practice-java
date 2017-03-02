package students.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import students.exception.UserDAOException;
import students.models.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Created by fedinskiy on 23.02.17.
 */
@Service
@Scope(value="session")
public class UserService {
	private static Logger logger = LogManager.getLogger(UserService.class);
	@Autowired
	private UserDAO userDAO;
	private int anInt;
//
//	private void showNumber(){
//		if(anInt==0) {
//			Random random = new Random();
//			anInt = random.nextInt();
//		}
//		logger.trace("User service int is "+anInt);
//	}
	public boolean authorize(String login, String password) throws UserDAOException {
//		showNumber();
		if(userDAO.getUserByLoginAndPassword(login, password).getIdUser() != 0){
			return true;
		} else {
			return false;
		}
	}
	public boolean RegisterUser(String login, String password) throws UserDAOException {
//		showNumber();
		if(userDAO.registrationUser(login, password).getIdUser() != 0){
			return true;
		} else {
			return false;
		}
	}
}
