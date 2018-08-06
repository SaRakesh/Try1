package com.jdk8.crypto.provider;

import java.security.MessageDigest;

public class MyProvider {

	
	public MyProvider() {
	} 
	//MessageDigest.getInstance("MD5", "ProviderC");

	public MessageDigest getProvider(String algorithm, String provider){
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
}
