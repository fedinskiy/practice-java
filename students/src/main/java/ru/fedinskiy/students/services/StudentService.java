package ru.fedinskiy.students.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedinskiy.students.exception.StudentDAOException;
import ru.fedinskiy.students.models.dao.StudentDAO;
import ru.fedinskiy.students.models.pojo.Student;

import java.util.List;


/**
 * Created by fedinskiy on 23.02.17.
 */
@Service
public class StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public List<Student> getAllStudents(){
		try {
			return studentDAO.getAllStudents();
		} catch (StudentDAOException e) {
			return null;
		}
	}
	
	public boolean deleteStudents(String[] chosen) {
		if (null==chosen) return false;
		if (chosen.length==0) return false;
		
		try {
			studentDAO.deleteStudentsById(chosen);
		} catch (StudentDAOException e) {
			return false;
		}
		return true;
	}
}
