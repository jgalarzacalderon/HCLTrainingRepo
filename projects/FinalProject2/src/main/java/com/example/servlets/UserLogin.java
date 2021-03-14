package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			  
			  SessionFactory factory = HibernateUtil.getSessionFactory();
			  Session session = factory.openSession(); 
			   		  		  
			  // using HQL 
			  List<Users> list = session.createQuery("from Users", Users.class).list();
			  
			  Users validate = new Users();		  
			  
			  validate.setName(request.getParameter("name"));
			  validate.setPassword(request.getParameter("password"));
			  validate.setEmail(request.getParameter("email"));
			  
			  PrintWriter out = response.getWriter(); out.println("<html><body>");	
			  
			  boolean userExist = false;
			  String errorMsg = "";
			  for (Users i : list) {
				  if (i.getName().equals(validate.getName()) && i.getPassword().equals(validate.getPassword())) {
					  userExist = true;
				  }
			  }

			  try {

				  if(userExist == true) {
				
					  response.sendRedirect("welcome.jsp");
					  
				  } else { out.println("<p>We're sorry, we're unable to locate an account with that username and password.<br> "
				  		+ "Please check your spelling and try again or create a new account <a href=\"registration.jsp\">here</a></p><br>");
				  	  
					out.println("<form action=\"login\" method=\"post\">\r\n" 
					  + "<label for=\"name\">Username: </label><br>\r\n" 
					  + "<input type=\"text\" id=\"name\" name=\"name\" required><br>\r\n" 
					  + "<label for=\"password\">Password:</label><br>\r\n" 
					  + "<input type=\"password\" id=\"password\" name=\"password\" max=\"32\" required><br><br>\r\n"
					  + "<input type=\"submit\" value=\"Login\">\r\n" + "</form><br>");	

 
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
