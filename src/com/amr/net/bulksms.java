package com.amr.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

public class bulksms {
	public static String adminsms(String adminmobile, String amrusername){
		
		try 
		{
	
		// Construct d1ata
		String phonenumbers=adminmobile;
		System.out.println("admin mobile number"+phonenumbers);
		String data="user=" + URLEncoder.encode("amrfibernet", "UTF-8");
		data +="&password=" + URLEncoder.encode("9949459593", "UTF-8");
		data +="&message=" + URLEncoder.encode("AMR Fibernet:Dear admin,bill payment of RS:600 is credited to AMR Fibernet account towards user:"+amrusername+".Please logon to PAYUMONEY for more details. ", "UTF-8");
		data +="&sender=" + URLEncoder.encode("AMRNet", "UTF-8");
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
	
	
public static String usersms(String usermobile){
		
		try 
		{
		// Construct data
		String phonenumbers=usermobile;
		String data="user=" + URLEncoder.encode("amrfibernet", "UTF-8");
		data +="&password=" + URLEncoder.encode("9949459593", "UTF-8");
		data +="&message=" + URLEncoder.encode("AMR Fibernet:Dear Customer, payment of RS:600 was successful towards AMR fibernet Bill", "UTF-8");
		data +="&sender=" + URLEncoder.encode("AMRNet", "UTF-8");
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
