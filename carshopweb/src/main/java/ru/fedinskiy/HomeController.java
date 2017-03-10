package ru.fedinskiy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.fedinskiy.models.Car;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;

/**
 * Created by fedinskiy on 06.03.17.
 */
@Controller

public class HomeController {
	private static Logger logger = LogManager.getLogger();
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showBasePage(){
		return "home";
	}
	
	@RequestMapping(value = "/text", method = RequestMethod.GET)
	public String showText(Model model){
		model.addAttribute("car", new Car(10000, "KIA", "x123ep"));
		model.addAttribute("myText", "My super text");
		return "text";
	}
	@RequestMapping(value = "/text", method = RequestMethod.POST)
	public String showText(Model model,
	                       @RequestParam(name = "param1",defaultValue = "1") String param,
	                       @ModelAttribute(name = "car") Car car){
		model.addAttribute("myText", param+car);
		return "text";
	}
	
	@RequestMapping(value = "/model", method = RequestMethod.GET)
	public ModelAndView showModelPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("text");
		modelAndView.addObject("car", new Car(5000, "Ока", "x125ep"));
		return modelAndView;
	}
	@RequestMapping(value = "/text/showfullcar", method = RequestMethod.POST)
	public ModelAndView showFullCar(@ModelAttribute("car") Car car){
		ModelAndView modelAndView=new ModelAndView("fullCarr");
		modelAndView.addObject("car", car);
		
		return modelAndView;
	}
}


