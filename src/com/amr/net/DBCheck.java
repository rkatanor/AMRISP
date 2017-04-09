package com.amr.net;



public class DBCheck {
public static void main(String[] args) {
	 if(LoginDAO.validate("rkatanor@gmail.com","123456")){  
	    	System.out.println("Credentials **** TRUE");
	        
	    }  
	    else{  
	        System.out.println("Invalid credentials");
	    } 
}
}
