package com.jdk8.crypto.key.KeyGenerator;

import java.security.SecureRandom;

import javax.crypto.KeyGenerator;

public class MyKeyGenerator {
	public static void main(String[] args) {
		new MyKeyGenerator().process();
	}

	private void process() {
		try {
			KeyGenerator keyGenerator1 = KeyGenerator.getInstance("AES");
			KeyGenerator keyGenerator2 = KeyGenerator.getInstance("AES");
			KeyGenerator keyGenerator3 = KeyGenerator.getInstance("AES");
			KeyGenerator keyGenerator4 = KeyGenerator.getInstance("AES");
			KeyGenerator keyGenerator5 = KeyGenerator.getInstance("AES");
			
			keyGenerator1.init(256);
			keyGenerator2.init(256, new SecureRandom());
			keyGenerator3.init(new SecureRandom());
//			keyGenerator3.init(new );
			
			System.out.println(keyGenerator1.generateKey());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
