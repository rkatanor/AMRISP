package com.amr.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
 * Servlet implementation class PlanServlet
 */
@WebServlet("/PlanServlet")
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       
          
        HttpSession session=request.getSession(false);  
        if(session!=null)
        {  
        	
        	String u_name = (String) session.getAttribute("user");
        	
        	//fetch data
        	
        	String name="";
    		int c_id=0;
    		int c_monthly_rental=0;
    		int c_due_amount=0;
    		String c_email="";
    		String c_package="";
    		//Date dt=null;
    		String c_mobile="";
    		String c_add="";
    		
    		try{  
    		Class.forName("oracle.jdbc.driver.OracleDriver");  
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMRFIBERNET","kata@1212AMR");
    		System.out.println(con);
    		Logger log=Logger.getLogger(LoginDAO.class);
    		
    		
    		PreparedStatement ps=con.prepareStatement(" SELECT * FROM USER_DETAILS WHERE CUST_NAME=? "); 
    	
    		ps.setString(1,u_name);  
    	
    		      
    		ResultSet rs=ps.executeQuery();  
    		
    	
    		while (rs.next()) {
    	        
    	         name = rs.getString(1);
    	         
    	         c_id=rs.getInt(2);
    	         c_email=rs.getString(3);
    	         c_package=rs.getString(4);
    	       
    	         
    	         c_mobile=rs.getString(5);
    	         c_add=rs.getString(6);
    	         c_monthly_rental=rs.getInt(7);
    	         c_due_amount=rs.getInt(8);
    	         
    	         
    	      
    	         
    	         session.setAttribute("cust_name", name);
    	         session.setAttribute("cust_id", c_id);
    	      
    	         session.setAttribute("cust_email", c_email);
    	         session.setAttribute("cust_package", c_package);
    	      
    	     
    	     
    	         session.setAttribute("cust_mobile", c_mobile);
    	         session.setAttribute("cust_add", c_add);
    	         session.setAttribute("cust_monthly_bill", c_monthly_rental);
      	       
    	         session.setAttribute("cust_due_amount", c_due_amount);
      	       
    	       
    	       
    	       System.out.println("USER LOGGED IN AS: " + name);
    	       System.out.println("USER ID :" + c_id);
    	       System.out.println("USER EMAIL ID :" + c_email);
    	       System.out.println("USER SUBSCRIPTION :" + c_package);
    	      
    	       System.out.println("USER MOBILE NUMBER: " + c_mobile);
    	       System.out.println("USER ADDRESS: " + c_add);
    					}
    		
    							}
    		          catch(Exception e){
    			       System.out.println(e);
    		          			}  
    		
        	response.sendRedirect("amrfibernetplandetails.jsp"); 
        }
        
        else{  
        	RequestDispatcher rd = request.getRequestDispatcher("amrfibernetlogin.jsp");
			out.println("<font color=red>Session expired.Please login</font>");
			rd.include(request, response);
        }  
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	


}
