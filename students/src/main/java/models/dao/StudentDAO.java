package models.dao;

import common.exception.StudentDAOException;
import models.connectors.Connector;
import models.pojo.Student;
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
public class StudentDAO {
	private static String SQL_ALL_STUDENTS = "SELECT * FROM main.students";
	private static String SQL_DELETE_STUDENT = "DELETE FROM main.students WHERE id in";
	private static Logger logger= LogManager.getLogger(StudentDAO.class);
	public static List<Student> getAllStudents() throws StudentDAOException {
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
	
	public static void deleteStudentsById(String[] chosen) throws StudentDAOException {
		try (Connection connection = Connector.getConnection()) {
			Statement statement = connection.createStatement();
			String sqlQ= new String(SQL_DELETE_STUDENT+"(");
			for(String idString:chosen){
				int id=Integer.parseInt(idString);
				sqlQ=sqlQ.concat(id+",");
			}
			sqlQ=sqlQ.substring(0,sqlQ.length()-1);
			sqlQ=sqlQ+")";
			logger.trace(sqlQ);
			statement.executeQuery(sqlQ);
		} catch (SQLException e) {
			logger.error(e);
			throw new StudentDAOException();
		}
	}
}
