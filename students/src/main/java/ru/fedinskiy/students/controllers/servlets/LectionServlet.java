package ru.fedinskiy.students.controllers.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.fedinskiy.students.models.pojo.Lection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.fedinskiy.students.services.LectionService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by fedinskiy on 24.02.17.
 */
public class LectionServlet extends HttpServlet {
	private static Logger logger = LogManager.getLogger(LectionServlet.class);
	@Autowired
	private LectionService lectionService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		final String operation = (req.getParameter("operation")==null)?"":req.getParameter("operation").toString();
		switch (operation) {
			case "edit":
				logger.trace("edit lections");
				final Lection lection = lectionService.getLectionById(req.getParameter("id").toString());
				req.setAttribute("lection", lection);
				req.getRequestDispatcher("editlection.jsp").forward(req, resp);
				break;
			default:
				logger.trace("opening lections");
				List<Lection> list = lectionService.getAllLections();
				req.setAttribute("lectionlist", list);
				req.getRequestDispatcher("lectionlist.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		final String operation = req.getParameter("operation").toString();
		
		logger.trace(operation);
		switch (operation) {
			case "delete":
				lectionService.deleteLections(req.getParameterValues("chosen"));
				break;
			case "savelection":
				lectionService.saveLection(fromRequest(req));
			case "add":
				break;
		}
		resp.sendRedirect("lections");
		
	}
	
	private Lection fromRequest(HttpServletRequest request) {
		Lection lection=new Lection();
		
		try {
			logger.trace(request.getCharacterEncoding());
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}
		lection.setId(Integer.valueOf(request.getParameter("id")));
		lection.setDate(LocalDate.parse(request.getParameter("date")));
		lection.setName(request.getParameter("name").toString());
		logger.trace(lection.getName());
		lection.setGroupId(Long.parseLong(request.getParameter("group_id")));
		return lection;
	}
}
