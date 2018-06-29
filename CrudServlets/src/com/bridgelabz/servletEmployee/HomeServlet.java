package com.bridgelabz.servletEmployee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */

public class HomeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();
		 
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		if(pwd.equals("1234"))
		{
			pw.print("<br>welcome to servlet<br>");  
			RequestDispatcher rd=request.getRequestDispatcher("/home.html");
			rd.forward(request, response);
		}else
		{
			pw.print("wrong password......enter correct password");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}
	

}
