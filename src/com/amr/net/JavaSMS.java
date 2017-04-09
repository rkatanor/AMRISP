package com.amr.net;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class JavaSMS {
public static void sendSMS() {
	// Replace with your username
	String username = "AMR Fibernet";

	// Replace with your API KEY (We have sent API KEY on activation email, also available on panel)
	String apikey = "lrb00IoktsKI0wqvflEG";

	// Replace with the destination mobile Number to which you want to send sms
	String mobile = "9701953773";

	// Replace if you have your own Sender ID, else donot change
	String senderid = "WEBSMS";

	// Replace with your Message content
	String message = "AMR FIbernet payment was successful.";

	// For Plain Text, use "txt" ; for Unicode symbols or regional Languages like hindi/tamil/kannada use "uni"
	String type="txt";

	//Prepare Url
	URLConnection myURLConnection=null;
	URL myURL=null;
	BufferedReader reader=null;

	//encoding message 
	String encoded_message=URLEncoder.encode(message);

	//Send SMS API
	String mainUrl="http://smshorizon.co.in/api/sendsms.php?";

	//Prepare parameter string 
	StringBuilder sbPostData= new StringBuilder(mainUrl);
	sbPostData.append("user="+username); 
	sbPostData.append("&apikey="+apikey);
	sbPostData.append("&message="+encoded_message);
	sbPostData.append("&mobile="+mobile);
	sbPostData.append("&senderid="+senderid);
	sbPostData.append("&type="+type);

	//final string
	mainUrl = sbPostData.toString();
	try
	{
	    //prepare connection
	    myURL = new URL(mainUrl);
	    myURLConnection = myURL.openConnection();
	    myURLConnection.connect();
	    reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
	    //reading response 
	    String response;
	    while ((response = reader.readLine()) != null) 
	    //print response 
	    System.out.println(response);
	    System.out.println("Message sent successfully!!!");
	    //finally close connection
	    reader.close();
	} 
	catch (IOException e) 
	{ 
		e.printStackTrace();
	} 
	
}
}
