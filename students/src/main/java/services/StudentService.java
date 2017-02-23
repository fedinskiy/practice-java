package services;

import common.exception.StudentDAOException;
import models.dao.StudentDAO;
import models.pojo.Student;

import java.util.ArrayList;
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
}
