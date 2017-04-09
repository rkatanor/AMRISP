package com.amr.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
public static void main(String[] args) throws ClassNotFoundException {
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMRFIBERNET","kata@1212AMR");
		System.out.println(con);
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from  LOGIN_SECURITY");  
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2));  
		  
		//step5 close the connection object  
		con.close();  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
}
}
