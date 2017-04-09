package com.amr.net;

public class Testmail {
public static void main(String[] args) {
	javamail mail=new javamail();
	mail.sendEamil("rkatanor@gmail.com", "AMR Fibernet Invoice", "Please check the invoice for month mar 2017");
	System.out.println("mail sent");
}
}
