package ru.fedinskiy.students.controllers.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedinskiy.students.controllers.servlets.LoginServlet;
import ru.fedinskiy.students.models.pojo.Student;
import ru.fedinskiy.students.services.StudentService;

import java.util.List;

/**
 * Created by fedinskiy on 06.03.17.
 */
@Controller
public class StudentsController {
	private static Logger logger = LogManager.getLogger(LoginServlet.class);
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getStudentList(Model model){
		List<Student> list = studentService.getAllStudents();
		model.addAttribute("studentList", list);
		return "list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST,params ={"operation=delete"} )
	public String deleteStudent(Model model, @RequestParam(value = "chosen") String [] chosen){
		System.out.println(chosen[0]);
		studentService.deleteStudents(chosen);
		List<Student> list = studentService.getAllStudents();
		model.addAttribute("studentList", list);
		return ControllerUtils.redirectTo("list");
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST,params ={"operation=add"} )
	public String addStudent(){
		return ControllerUtils.redirectTo("list");
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST,params ={"operation=edit"} )
	public String editStudent(){
		return ControllerUtils.redirectTo("list");
	}
}
