package com.mr;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.ServletException;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		String roll = SessionHelper.currentUser(req);
		if (roll != null) {
			//HttpSession s1 = req.getSession();
			//req.getRequestDispatcher("dashboard").forward(req, resp);
			
			resp.sendRedirect("dashboard.html");
		} else {
			//
			System.out.println("hi");
			resp.sendRedirect("login.html");
			//req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}