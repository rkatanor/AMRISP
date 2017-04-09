package com.amr.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class PaymentSuccess
 */
@WebServlet("/PaymentSuccess")
public class PaymentSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSuccess() {
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
		  if(session!=null){  
			  System.out.println("***inside payment success****");
			  String u_name = (String) session.getAttribute("user");
			  System.out.println(u_name);
			  String u_mobile=(String) session.getAttribute("cust_mobile");
			  System.out.println(u_mobile);
			  String u_email=(String) session.getAttribute("cust_email");
			  System.out.println(u_email);
			  zeroingAmount(u_name);
			  System.out.println("Due amount cleared:::");
			  sendSMS(u_mobile,u_name);
			  System.out.println("----Confirmation SMS has been sent to User");
			  System.out.println("----Confirmation SMS has been sent to AMR admin");
			  sendMail(u_email);
			  System.out.println("----Acknowledgment has been sent to user registered email id ");
			  
			 
	        	response.sendRedirect("http://www.amrfibernet.in/amrhome/PlanServlet"); 
	        }  
	        else{  
	        	RequestDispatcher rd = request.getRequestDispatcher("amrfibernetlogin.jsp");
				out.println("<font color=red>Session expired.Please login</font>");
				rd.include(request, response);
	        }  
	        out.close();
    	
	}
	public static void zeroingAmount(String name){  
		  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMRFIBERNET","kata@1212AMR");
		System.out.println(con);
		Logger log=Logger.getLogger(LoginDAO.class);
		log.info("connection successfull");
		
		String updateTableSQL = "UPDATE USER_DETAILS SET DUE_AMOUNT = ? WHERE CUST_NAME = ?";
		PreparedStatement preparedStatement = con.prepareStatement(updateTableSQL);
		preparedStatement.setInt(1, 0);
		preparedStatement.setString(2, name);
		// execute insert SQL stetement
		preparedStatement .executeUpdate();
		System.out.println("Amount zeroed..");
		 
	
		     
		}catch(Exception e){System.out.println(e);}  
		
		}  
	
	public static void sendSMS(String usermobile,String serviceuser){
		 bulksms.usersms(usermobile);
		  bulksms.adminsms("9949459593",serviceuser);
	}
	public static void sendMail(String email){
		 String to = email;

	      // Sender's email ID needs to be mentioned
	      String from = "amrfiber@gmail.com";
	      final String username = "amrfiber@gmail.com";//change accordingly
	      final String password = "kata@1212AMR";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.starttls.enable","true");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "465");
	      props.put("mail.smtp.socketFactory.port", "465");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	      props.put("mail.smtp.socketFactory.fallback", "false");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
		});

	      try {
	            // Create a default MimeMessage object.
	            Message message = new MimeMessage(session);

	   	   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(from));

		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	              InternetAddress.parse(to));

		   // Set Subject: header field
		   message.setSubject("AMR Fibernet Bill Payment");

		   // Send the actual HTML message, as big as you like
		   message.setContent(
				   
	              "<h1>This is the acknowledge to your payment towards AMR Fibernet</h1>",
	             "text/html");
		   message.setContent(
				   
		              "<h3><i>This is the acknowledge to your Bill Payment towards AMR Fibernet.Your payment of INR 600 has been received successfully</i></h3>",
		             "text/html");
		   
		   
		   
		   

		   // Send message
		   Transport.send(message);

		   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
		   e.printStackTrace();
		   throw new RuntimeException(e);
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
