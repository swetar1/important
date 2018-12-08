package com.project.goshopping;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login2")
public class Mobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Mobile() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		System.out.println("servlet");

		String name1 = request.getParameter("name");
		String pass1 = request.getParameter("password");

		LoginDAO obj = new LoginDAO();

		try {
			boolean valid = obj.checkLogin(name1, pass1);
			System.out.println(valid);
			if (valid) {
		/*		System.out.println("redirect");*/
				RequestDispatcher rd=request.getRequestDispatcher("mobile.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
