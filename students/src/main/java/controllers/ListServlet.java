package controllers;

import models.pojo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.StudentService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fedinskiy on 23.02.17.
 */
public class ListServlet extends HttpServlet {
	Logger logger = LogManager.getLogger(ListServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = StudentService.getAllStudents();
		req.setAttribute("studentList", list);
		req.getRequestDispatcher("list.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.trace("doingPost");
		final Map<String, String[]> parameterMap = req.getParameterMap();
		switch (req.getParameter("operation").toString()){
			case "edit":
				break;
			case "delete":
				StudentService.deleteStudents(req.getParameterValues("chosen"));
				break;
			case "add":
				break;
		}
		logger.trace(req.getParameter("operation").toString());
		resp.sendRedirect("list");
		/**
		 * редактирование
		 * удаление
		 * добавление
		 * обработка ошибок
		 * фильтрация по сессии
		 */
	}
}
