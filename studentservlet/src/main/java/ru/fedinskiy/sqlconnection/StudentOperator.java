package ru.fedinskiy.sqlconnection;

import ru.fedinskiy.models.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedinskiy on 16.02.17.
 */
public class StudentOperator extends TableOperator {
	public StudentOperator() {
		super("students","name","id", new String[]{"id","name","birthdate","sex","group_id"});
	}
	public List<Student> getStudents() throws SQLException {
		ResultSet sqlStudents=this.getAllInfo();
		List<Student> students= new ArrayList<>();
		while (sqlStudents.next()){
			students.add(studentFromResultSet(sqlStudents));
		}
		return students;
	}
	private Student studentFromResultSet(ResultSet results) throws SQLException {
		Student student=new Student();
		student.setName(results.getString("name"));
		return student;
	}
}
