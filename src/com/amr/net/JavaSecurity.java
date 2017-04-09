package com.amr.net;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JavaSecurity {
	public static void main(String[] args) 
	{
		String seed = "katanor";
		String myIpValue = "12345";

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(seed);
		String encrypted= encryptor.encrypt(myIpValue);
		System.out.println(encrypted);
		decrypt();
	}
	
	public static void decrypt()
	{
		String seed = "katanor";
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(seed);
		String encrypted="3HvJp1NAKNqDYN5yw9cxUA==";
		String decrypted = encryptor.decrypt(encrypted);
		System.out.println(decrypted);
	}
}

