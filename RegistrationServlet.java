package com.project.goshopping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		String firstName=request.getParameter("username");
		String lastName=request.getParameter("email");
		String email=request.getParameter("password");
		String phoneNum=request.getParameter("confirmpassword");
		
		
		String password=request.getParameter("password2");

		
		
		

	String type=getInsertData(firstName,password,lastName,email,phoneNum);
		   if(type.equals("done"))
	   {
		   pw.println("done!");
		   
		  RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
		   rs.forward(request, response);
		   }
		   else{
			   pw.println("id is duplicate");
		   }
		
	}
	



public String getInsertData(String username,String email,String password,String confirmpassword){
		
		DAOClass dao=new DAOClass();
		return dao.getInsertData( username, email,password,confirmpassword);
		
	}
	}

}
