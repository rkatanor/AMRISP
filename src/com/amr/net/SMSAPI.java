package com.test.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMSExternalAPI {
public static String usersms(String usermobile, int rechargeamount){
		
		try 
		{
		// Construct data
		String phonenumbers=usermobile;
		String data="user=" + URLEncoder.encode("", "UTF-8");
		data +="&password=" + URLEncoder.encode("", "UTF-8");
		data +="&message=" + URLEncoder.encode("Javainstances :Dear Customer, your recharge of INR : " +rechargeamount+  "   was successful ", "UTF-8");
		data +="&sender=" + URLEncoder.encode("JISSMS", "UTF-8");
		data +="&mobile=" + URLEncoder.encode(phonenumbers, "UTF-8");
		data +="&type=" + URLEncoder.encode("3", "UTF-8");
		URL url = new URL("http://login.bulksmsgateway.in/sendmessage.php?"+data);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data);
		wr.flush();
		// Get the response
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		String sResult1="";
		while ((line = rd.readLine()) != null) 
		{
		// Process line...
		sResult1=sResult1+line+" ";
		}
		wr.close();
		rd.close();
		return sResult1;
		} 
		catch (Exception e)
		{
		System.out.println("Error SMS "+e);
		return "ERROR"+e;
		}
	}
}
