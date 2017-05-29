package com.mr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class StudLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	boolean isPresent;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		Query q1 = new Query("Student");
		PreparedQuery prepd = ds.prepare(q1);
		for (Entity ent : prepd.asIterable()) {
			isPresent = false;
			String dname = (String) ent.getProperty("Stud Id");
			String dpass = ent.getProperty("DOB").toString();
			System.out.println(dname+uname);
			if ((dname.equals(uname))&& (dpass.equals(pass))) {
				//session starts here 
				HttpSession session = req.getSession();
				session.setAttribute("StudID",uname);
				
				System.out.println("the session id in login page should not be nul  "+session.getAttribute("StudID"));
				isPresent = true;
				break;
			} 
	
			
		}
		if(isPresent){
			resp.sendRedirect("dashboard.html");
		}
		else {
			resp.sendRedirect("logins");
		}
		
		
		
		

	}
}
