package ru.fedinskiy.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.fedinskiy.models.Student;
import ru.fedinskiy.sqlconnection.StudentOperator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedinskiy on 22.02.17.
 */
public class StudentsServlet extends HttpServlet {
	private static Logger logger= LogManager.getLogger(StudentsServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentOperator so = new StudentOperator();
		List<Student> students=new ArrayList<>();
		try {
			students = so.getStudents();
			logger.trace(students.size());
		} catch (SQLException e) {
			logger.error(e);
		}
		req.setAttribute("studentList", students);
		req.getRequestDispatcher("studentsshow.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
