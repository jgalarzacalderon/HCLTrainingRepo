package com.hcl;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet(urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
        	PrintWriter out = response.getWriter();
            out.println("<html><body>");
                 
            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);
                
            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
				
            String id = request.getParameter("id"); 
            
            Statement stmt =
			conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY); ResultSet rst =
			stmt.executeQuery("select * from products where id = " + id);
			
			if (rst.next() == false) {
	        	out.println("Sorry, the product could not be found<br>");
			} else {
				
				out.println("<table><tr><th>Name</th><th>Color</th><th>Price</th></tr>");

				do {
					out.println("<tr><td>" + rst.getString("name") + "</td>"
							+ "<td>" + rst.getString("color") + "</td><td>" + rst.getBigDecimal("price")
							+ "</td></tr>");
				} while (rst.next());
				
			}
			  
			out.println("</table>");
			
			stmt.close();        
           
            conn.closeConnection();
        
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        } catch (SQLException e) {
        	e.printStackTrace();
        	PrintWriter out = response.getWriter();
        	out.println("<html><body>Sorry, product ID should only contain numbers and no special characters<br>");
        } finally {
        	PrintWriter out = response.getWriter();
        	out.println("<a href=\"/ProductIDProject\">Return to home</a><br>");
        	out.println("</body></html>");
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
