package com.amr.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("userpass");  
	       
	    if(LoginDAO.validate(n, p)){  
	    	
	    	HttpSession session = request.getSession(true); // reuse existing
			// session if exist
			// or create one
	    	//if validation successfull call below method getUsername()
	    	String user_name=getUsername(n);
	    	session.setAttribute("user", user_name);
	    	//session.setMaxInactiveInterval(240); // 30 seconds
	    	response.sendRedirect("amrfibernetwelcome.jsp");
	    }  
	    else{  
	    	RequestDispatcher rd = request.getRequestDispatcher("amrfibernetlogin.jsp");
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
	    }  
	          
	    out.close();  
	}
	public static String getUsername(String name){  
		String u_name="";  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMRFIBERNET","kata@1212AMR");
		System.out.println(con);
		Logger log=Logger.getLogger(LoginDAO.class);
		log.info("connection successfull");
		
		PreparedStatement ps=con.prepareStatement(" SELECT * FROM USER_DETAILS WHERE CUST_EMAIL=? ");  
		ps.setString(1,name);  
	
		      
		ResultSet rs=ps.executeQuery();  
		while (rs.next()) {
	        
	         u_name = rs.getString(1);
	     
	       System.out.println("***"+u_name);
	      }
		
	
		    System.out.println("############"+u_name);      
		}catch(Exception e){System.out.println(e);}  
		return u_name;  
		}  

}
