package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fedinskiy on 22.02.17.
 */
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("index get1 "+req.getParts());
		getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
		System.out.println("index get "+req.getQueryString());
}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("index post1");
		if(req.getCharacterEncoding()==null){
			System.out.println("new encoding index");
			req.setCharacterEncoding("UTF-8");
		}
		String input = req.getParameter("input");
		System.out.println("index post2 "+input);
		req.setAttribute("input", input);
		//resp.sendRedirect("/list");
		req.getRequestDispatcher("/list").forward(req, resp);
		System.out.println("index post2");
	}
}
