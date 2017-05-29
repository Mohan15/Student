package com.mr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class StudRegister extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Entity stud ;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		String name=req.getParameter("name");
		String address=req.getParameter("adr");
		String rollno=req.getParameter("rollno");
		String DOB=req.getParameter("dob");
		
		
		stud=new Entity("Student",name);
		
		stud.setProperty("Name", name);
		stud.setProperty("Address", address);
		stud.setProperty("Stud Id", rollno);
		stud.setProperty("DOB",DOB);
		ds.put(stud);
		System.out.println(ds);
		resp.sendRedirect("logins");
	}
}