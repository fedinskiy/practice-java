package services;

import common.exception.UserDAOException;
import models.dao.UserDAO;

/**
 * Created by fedinskiy on 23.02.17.
 */
public class UserService {
	public static boolean authorize(String login, String password) throws UserDAOException {
		if(UserDAO.getUserByLoginAndPassword(login, password).getIdUser() != 0){
			return true;
		} else {
			return false;
		}
	}
	public static boolean RegisterUser(String login, String password) throws UserDAOException {
		if(UserDAO.registrationUser(login, password).getIdUser() != 0){
			return true;
		} else {
			return false;
		}
	}
}
