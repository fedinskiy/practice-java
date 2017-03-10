package ru.fedinskiy.students.controllers.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedinskiy.students.models.pojo.Lection;
import ru.fedinskiy.students.services.LectionService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by fedinskiy on 06.03.17.
 */
@Controller
public class LectionController {
		private static Logger logger = LogManager.getLogger(ru.fedinskiy.students.controllers.servlets.LectionServlet.class);
		@Autowired
		private LectionService lectionService;

	@RequestMapping(value = "/lections", method = RequestMethod.GET)
	public String showLections(Model model){
		List<Lection> list = lectionService.getAllLections();
		model.addAttribute("lectionlist", list);
		return "lectionlist";
	}
	@RequestMapping(value = "/lections", method = RequestMethod.GET, params = {"operation=edit"})
	public String editLection(Model model, @RequestParam(value = "id") String id){
		final Lection lection = lectionService.getLectionById(id);
		model.addAttribute("lection", lection);
		return "editlection";
	}
	
	@RequestMapping(value = "/lections", method = RequestMethod.POST,params ={"operation=delete"} )
	public String deleteLection(@RequestParam(value = "chosen") String[]chosen){
		lectionService.deleteLections(chosen);
		return ControllerUtils.redirectTo("lections");
	}
	@RequestMapping(value = "/lections", method = RequestMethod.POST,params ={"operation=add"} )
	public String addLection(){
		return ControllerUtils.redirectTo("lections");
	}
	@RequestMapping(value = "/lections", method = RequestMethod.POST,params ={"operation=savelection"} )
	public String saveLection(@RequestParam(value = "id") String id,
	                          @RequestParam(value = "date") String date,
	                          @RequestParam(value = "name") String name,
	                          @RequestParam(value = "group_id") String groupId){
		System.out.println("name is "+name);
		lectionService.saveLection(fromRequest(Integer.parseInt(id),LocalDate.parse(date),name,Long.parseLong(groupId)));
		return ControllerUtils.redirectTo("lections");
	}
	
	private Lection fromRequest(int id, LocalDate date, String name, Long groupId) {
		Lection lection=new Lection();
		
		lection.setId(id);
		lection.setDate(date);
		lection.setName(name);
		logger.trace(lection.getName());
		lection.setGroupId(groupId);
		return lection;
	}
}
