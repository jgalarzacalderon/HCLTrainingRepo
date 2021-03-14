package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.StoredProcedureQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.HibernateUtil;
import com.example.Users;

/**
 * Servlet implementation class InitHibernate
 */
@WebServlet("/InitHibernate")
public class InitHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitHibernate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		  try { 
			  
		  SessionFactory factory = HibernateUtil.getSessionFactory();
		  Session session = factory.openSession(); 
		 		  		  
		  // using HQL 
		  List<Users> list = session.createQuery("from Users", Users.class).list();
		  
		  Users newUser = new Users();		  
		  
		  newUser.setName(request.getParameter("name"));
		  newUser.setPassword(request.getParameter("password"));
		  newUser.setEmail(request.getParameter("email"));
		  
		  session.beginTransaction();
		  
		  PrintWriter out = response.getWriter(); out.println("<html><body>");	
		    		  
		  boolean userExist = false;
		  String errorMsg = "";
		  for (Users i : list) {
			  if (i.getEmail().equals(newUser.getEmail()) || i.getName().equals(newUser.getEmail())) {
				  userExist = true;
				  errorMsg = "<h2>Unable to create account</h2>An account already exists with either the username, email or both. Unable to create account.<br>"
				  		+ "Please login below or return to the registration screen "
				  		+ "<a href=\"registration.jsp\">here</a><br><br>"
				  		+ "<form action=\"login\" method=\"post\">\r\n" 
						+ "<label for=\"name\">Username: </label><br>\r\n" 
						+ "<input type=\"text\" id=\"name\" name=\"name\" required><br>\r\n" 
						+ "<label for=\"password\">Password:</label><br>\r\n" 
						+ "<input type=\"password\" id=\"password\" name=\"password\" max=\"32\" required><br><br>\r\n"
						+ "<input type=\"submit\" value=\"Login\">\r\n" + "</form><br>";	
			  }
		  }

		  try {

			  if(userExist == true) {
				  
				  out.println(errorMsg);
				  
			  } else { out.println("<p>New user account created</p>" 
					  + "<form action=\"login\" method=\"post\">\r\n" 
					  + "<label for=\"name\">Username: </label><br>\r\n" 
					  + "<input type=\"text\" id=\"name\" name=\"name\" required><br>\r\n" 
					  + "<label for=\"password\">Password:</label><br>\r\n" 
					  + "<input type=\"password\" id=\"password\" name=\"password\" max=\"32\" required><br><br>\r\n"
					  + "<input type=\"submit\" value=\"Login\">\r\n" + "</form><br>");
			  	  out.println("<br><a href=\"/FinalProject2\">Return to Login Page</a><br>");
			  	  session.save(newUser); 
				  session.getTransaction().commit(); 
			  }
			  
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println(e);
		  }

		  out.println("</body></html>");
		  
		  session.close();
		  
		  } catch (Exception ex) { throw ex; }
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
