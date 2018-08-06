package com.jdk8.crypto;

import java.security.SecureRandom;

public class TryEncription1 {
	public static void main(String[] args) {
		TryEncription1 instance = new TryEncription1();
		instance.encrypt1();
	}
	int iterCount = 12288 ;
	int derivedKeyLength = 256 ;
	
	private void encrypt1() {
		String password = "password123";
		byte[] salt = new byte[128];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);
		

		
	}
}
