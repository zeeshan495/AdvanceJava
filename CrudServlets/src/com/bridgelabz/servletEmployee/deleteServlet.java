package com.bridgelabz.servletEmployee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteServlet
 */

public class deleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String empID=request.getParameter("id");
	System.out.println(empID+"employee ID inside delete servlet");
	try {
		int status=DaoEmployees.delete(empID);
		response.sendRedirect("displayServlet");
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	
	}

}
