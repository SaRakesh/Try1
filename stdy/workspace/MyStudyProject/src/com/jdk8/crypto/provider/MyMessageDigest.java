package com.jdk8.crypto.provider;

import java.security.MessageDigest;

public class MyMessageDigest {

	
	public MyMessageDigest() {
	} 
	//MessageDigest.getInstance("MD5", "ProviderC");

	public MessageDigest getProvider(String algorithm, String provider){
		try {
			if(provider != null )
				return MessageDigest.getInstance(algorithm, provider);
			else
				return MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
}
