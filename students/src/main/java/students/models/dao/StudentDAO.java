package students.models.dao;

import org.springframework.stereotype.Component;
import students.exception.StudentDAOException;
import students.models.connectors.Connector;
import students.models.pojo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedinskiy on 23.02.17.
 */
@Component
public class StudentDAO extends BasicDAO{
	private static String SQL_ALL_STUDENTS = "SELECT * FROM main.students";
	private static String SQL_DELETE_STUDENT = "DELETE FROM main.students WHERE id in";
	private static Logger logger= LogManager.getLogger(StudentDAO.class);
	public List<Student> getAllStudents() throws StudentDAOException {
		List<Student> studentList = new ArrayList<>();
		try (Connection connection = Connector.getConnection()) {
			Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(SQL_ALL_STUDENTS);
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setBirthdate(resultSet.getDate("birthdate"));
				student.setSex(resultSet.getString("sex"));
				studentList.add(student);
			}
		} catch (SQLException e) {
			logger.error(e);
			throw new StudentDAOException();
		}
		return studentList;
	}
	
	public void deleteStudentsById(String[] chosen) throws StudentDAOException {
		try {
			deleteById(chosen, SQL_DELETE_STUDENT);
		} catch (SQLException e) {
			logger.error(e);
			throw new StudentDAOException();
		}
	}
}
