package com.mr;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class SessionHelper {
	public static String currentUser(HttpServletRequest req) {
		HttpSession session =req.getSession(false);
		if (session != null) {
			String s1 = (String) session.getAttribute("StudID");
			return s1;
		} else {
			return null;
		}
	}

	public static boolean isPresent(String rollno) {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Key rollnoo = KeyFactory.createKey("Student", rollno);
		try {
			Entity temp = ds.get(rollnoo);
			System.out.println(temp);
			return true;

		} catch (EntityNotFoundException e1) {
			// TODO Auto-generated catch block
			return false;

			// e1.printStackTrace();
		}

	}

}
