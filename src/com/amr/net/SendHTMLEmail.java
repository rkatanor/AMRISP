package com.amr.net;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendHTMLEmail {
   public static void main(String[] args) {
      // Recipient's email ID needs to be mentioned.
      String to = "prasu.lilly@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "rkatanor@gmail.com";
      final String username = "rkatanor@gmail.com";//change accordingly
      final String password = "$12471266";//change accordingly

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
	   message.setSubject("Testing Subject");

	   // Send the actual HTML message, as big as you like
	   message.setContent(
			   
              "<h1>This is the acknowledge to your payment towards AMR Fibernet</h1>",
             "text/html");
	   message.setContent(
			   
	              "<h1>Your payment of INR 600 has been received successfully</h1>",
	             "text/html");
	   
	   
	   
	   

	   // Send message
	   Transport.send(message);

	   System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
	   e.printStackTrace();
	   throw new RuntimeException(e);
      }
   }
}