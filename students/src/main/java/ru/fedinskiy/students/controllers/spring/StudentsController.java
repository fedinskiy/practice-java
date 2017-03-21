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
import ru.fedinskiy.students.entities.StudentsEntity;
import ru.fedinskiy.students.interfaces.StudentService;
import ru.fedinskiy.students.models.pojo.Student;
import ru.fedinskiy.students.services.StudentDAOService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fedinskiy on 06.03.17.
 */
@Controller
public class StudentsController {
	private static Logger logger = LogManager.getLogger(StudentsController.class);
	
	@Autowired
	private StudentDAOService studentDAOService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getStudentList(Model model){
		final List<StudentsEntity> all = studentService.findAll();
		List<Student> list=new ArrayList<>(all.size());
		logger.info(all.size());
		for (StudentsEntity studentsEntity : all) {
			Student student=new Student();
			student.setBirthdate(studentsEntity.getBirthdate());
			student.setName(studentsEntity.getName());
			student.setSex(studentsEntity.getSex());
			student.setId(studentsEntity.getId());
			list.add(student);
		}
		
		model.addAttribute("studentList", list);
		return "list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST,params ={"operation=delete"} )
	public String deleteStudent(Model model, @RequestParam(value = "chosen") String [] chosen){
		System.out.println(chosen[0]);
		final List<Integer> ids = Arrays.stream(chosen).map(
				(String string) -> {
					return Integer.parseInt(string);
				}
		).collect(Collectors.toList());
		studentService.deleteStudents(ids);
//		List<Student> list = studentDAOService.getAllStudents();
//		model.addAttribute("studentList", list);
		return ControllerUtils.redirectTo("list");
	}
}
