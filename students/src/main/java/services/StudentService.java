package services;

import common.exception.StudentDAOException;
import models.dao.StudentDAO;
import models.pojo.Student;

import java.util.List;


/**
 * Created by fedinskiy on 23.02.17.
 */
public class StudentService {
	public static List<Student> getAllStudents(){
		try {
			return StudentDAO.getAllStudents();
		} catch (StudentDAOException e) {
			return null;
		}
	}
	
	public static boolean deleteStudents(String[] chosen) {
		if (null==chosen) return false;
		if (chosen.length==0) return false;
		
		try {
			StudentDAO.deleteStudentsById(chosen);
		} catch (StudentDAOException e) {
			return false;
		}
		return true;
	}
}
