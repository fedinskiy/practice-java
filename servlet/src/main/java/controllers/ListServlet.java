package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fedinskiy on 22.02.17.
 */
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("list get");
		resp.sendRedirect("/list.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("list post"+req.getCharacterEncoding());
		System.out.println("server responce "+resp.getCharacterEncoding());
		resp.setCharacterEncoding("UTF-8");
		System.out.println("server responce2 "+resp.getCharacterEncoding());
		
//		PrintWriter pw = resp.getWriter();
//		System.out.println("req is "+req.getAttribute("input").toString());
//		pw.append(req.getAttribute("input").toString());
	//	pw.close();
	}
}
