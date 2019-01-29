package com.Pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class Loginservlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("I am in init..");
	}

	public void destroy() {
		System.out.println("I am in destroy..");
	}

	public Loginservlet() {
		// TODO Auto-generated constructor stub
	System.out.println("I'm in Constructor");
	}
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
           System.out.println("I'm in get");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	    System.out.println("I'm in Post");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("I'm in servise");
		
		System.out.println("ip address of aclient :" +request.getRemoteAddr());
		request.getCookies();

		
		String Username = request.getParameter("uname");
		System.out.println("User Name = " + Username);

		String Password = request.getParameter("pwd");
		System.out.println("Password = " + Password);
		
		

		if ( ("jbk".equals(Username) && ("123456".equals(Password)) ) ) {
			
			System.out.println("You are correct");
			ArrayList<String> al=new ArrayList<>();
			al.add("AA");
			al.add("BB");
			al.add("CC");
			
			request.setAttribute("data", al);
			System.out.println("I am before request dispatcher");

			RequestDispatcher rd = request.getRequestDispatcher("Loginservlet.jsp");
			rd.forward(request, response);
			
			System.out.println("I am After request dispatcher");


		} else {
			
			
			request.setAttribute("msg", "Username and Password is not matching..." );
			RequestDispatcher rd = request.getRequestDispatcher("Loginservlet.jsp");
			rd.forward(request, response);
		}
		
		
		

	}

}
