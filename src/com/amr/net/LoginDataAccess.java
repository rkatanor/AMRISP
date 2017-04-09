package com.amr.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class LoginDataAccess {
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMRFIBERNET","kata@1212AMR");
		System.out.println(con);
		Logger log=Logger.getLogger(LoginDAO.class);
		log.info("connection successfull");
		Statement stmt=con.createStatement();  
		//PreparedStatement ps=con.prepareStatement("select * from LOGIN_SECURITY where USER_NAME=? and USER_PASSWORD=?");  
		//String encryptedpassword =encrypt(pass);
		//log.info("encrypted password :"  +encryptedpassword);
		//ps.setString(1,name);  
		//ps.setString(2,encrypt(encryptedpassword)); 
		ResultSet rs=stmt.executeQuery("select * from  LOGIN_SECURITY");  
		String dbusername="";
		String dbpassword="";
		while(rs.next())  {
		System.out.println(rs.getString(1)+"  "+rs.getString(2));  
		 
		 dbusername=rs.getString(1);
		 dbpassword=rs.getString(2);
		}
		String orginalpass =decrypt(dbpassword);
		//ResultSet rs=ps.executeQuery();  
		//status=rs.next();  
	      if("12345".equals(orginalpass))
	      {
	    	  status=true;
	      }
	      
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  
	public static String encrypt(String password){
		String seed = "katanor";
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(seed);
		String encrypted= encryptor.encrypt(password);
		System.out.println(encrypted);
		return encrypted;
	}
	public static String decrypt(String dbpass)
	{
		String seed = "katanor";
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(seed);
		String encrypted="3HvJp1NAKNqDYN5yw9cxUA==";
		String decrypted = encryptor.decrypt(encrypted);
		System.out.println(decrypted);
		return decrypted;
	}
}
