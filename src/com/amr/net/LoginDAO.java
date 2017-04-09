package com.amr.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class LoginDAO {
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMRFIBERNET","kata@1212AMR");
		System.out.println(con);
		Logger log=Logger.getLogger(LoginDAO.class);
		log.info("connection successfull");
		      
		PreparedStatement ps=con.prepareStatement("select * from USER_SECURITY where USER_NAME=? and USER_PASSWORD=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  
}
