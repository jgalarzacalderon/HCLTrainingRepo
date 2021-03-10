package com.pets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


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
                // This method is used to print the contents of the products table from the pets database out to the webpage for the user
        		// to view all of the pets currently available, along with their price, color, and name. 
        	
                 try {
                           
	                	 SessionFactory factory = HibernateUtil.getSessionFactory();
	                     Session session = factory.openSession();
	                     
	                     List<Products> list = session.createQuery("from Products", Products.class).list();
	                     
	                     session.close();
	                     
	                      PrintWriter out = response.getWriter();
	                      out.println("<html><body>");
	                      out.println("<b>Product Listing</b><br>");
	                      for(Products p: list) {
	                              out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
	                                              ", Price: " + String.valueOf(p.getPrice()) + ", Color: " + p.getColor().toString() + "<br>");
	                      }
	                      
	                      out.println("<br><a href=\"/AddProductProject\">Return to home</a><br>");
	                      out.println("</body></html>");
                         
                 	} catch (Exception ex) {
                                 throw ex;
                    }

        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // The doPost method has been written so that it will take the input from the addpet.jsp that the web user enters
        		// It will use that input and use Hibernate to store that information and commit it to the database to update it. 
  
        		
	            try {
					PrintWriter out = response.getWriter();
					out.println("<html><body>");
					out.println("<b>Adding Pet</b> " + request.getParameter("name") + "<br>");
					
					SessionFactory factory = HibernateUtil.getSessionFactory();
                    Session session = factory.openSession();
					
					session.beginTransaction();
					
					//Add new pet object
					Products pet = new Products();
					
					String bigString = request.getParameter("price");
					BigDecimal big = new BigDecimal(bigString);
					String name = request.getParameter("name");
					String color = request.getParameter("color");
					
					pet.setName(name);
					pet.setColor(color);
					pet.setPrice(big);
							
											
					//Save the pet in the database
					session.save(pet);
					
					//Commit the transaction
					session.getTransaction().commit();
	
					session.close();
					
					out.println("</body></html>");
					
				} catch (Exception e) {
					e.printStackTrace();
		            PrintWriter out = response.getWriter();
					out.println("<br>Invalid input, unable to commit to database. Please try again.<br><br>");

				}
        	
	            PrintWriter out = response.getWriter();
	        	out.println("<a href=\"/AddProductProject\">Return to home</a><br>");
	        	out.println("</body></html>");
                // doGet(request, response);
        }

}
