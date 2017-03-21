package ru.fedinskiy.students.controllers.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.fedinskiy.students.entities.StudentsEntity;
import ru.fedinskiy.students.interfaces.StudentService;
import ru.fedinskiy.students.models.pojo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.fedinskiy.students.services.StudentDAOService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fedinskiy on 23.02.17.
 */
public class ListServlet extends HttpServlet {
	Logger logger = LogManager.getLogger(ListServlet.class);
	@Autowired
	private StudentDAOService studentDAOService;
	
	private StudentService studentService;
	
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final List<StudentsEntity> all = studentService.findAll();
		List<Student> list=new ArrayList<>(all.size());
		for (StudentsEntity studentsEntity : all) {
			Student student=new Student();
			student.setBirthdate(studentsEntity.getBirthdate());
			student.setName(studentsEntity.getName());
			student.setSex(studentsEntity.getSex());
		}
		
		 
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
				studentDAOService.deleteStudents(req.getParameterValues("chosen"));
				break;
			case "add":
				break;
		}
		logger.trace(req.getParameter("operation").toString());
		resp.sendRedirect("list");
		/**
		 *TODO
		 * удаление
		 * добавление
		 * обработка ошибок
		 * фильтрация по сессии
		 *
		 * лекции:
		 * добавление лекций
		 * редактирование
		 *
		 * добавляем студенту email
		 * при старте приложения — если до лекции меньше часа, то шлем уведомления всем студентам
		 * реализовать таймер с оповещением о старте лекции с проверкой раз в час.
		 * оповещение о входе на имейл
		 */
	}
}
