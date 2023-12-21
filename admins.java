package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.admindao;
import com.model.student;
import com.model.student100;

@WebServlet("/")
public class admins extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		
		switch (path) {
			default:getLogin(request,response);
			case "/validate":validateUser(request,response);
			break;
			
			case "/getstudent":getStudent(request,response);
			break;
			
			case "/insert":insertIntoStudent(request,response);
			break;
			case "/display":displayStudent(request,response);
			
		}	
	}


	private void displayStudent(HttpServletRequest request, HttpServletResponse response) {

		admindao ad=new admindao();
		ArrayList<student100> al=ad.displayStudent();
		request.setAttribute("display", al);
		
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	private void insertIntoStudent(HttpServletRequest request, HttpServletResponse response) {

		int sno=Integer.parseInt(request.getParameter("sno"));
		String sname=request.getParameter("sname");
		String sub=request.getParameter("sub");
		student100 s=new student100(sno, sname, sub);
		admindao a = new admindao();
		int i=a.insert(s);
		if(i==1) {
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}


	private void getStudent(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void validateUser(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		student s=new student(email,pass);
		admindao ad = new admindao();
		String res=ad.validate(s);
		
		if(res.equals("success")) {
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}


	private void getLogin(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
