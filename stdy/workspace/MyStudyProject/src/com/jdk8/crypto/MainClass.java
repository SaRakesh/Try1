package com.jdk8.crypto;

import java.security.MessageDigest;

import com.jdk8.crypto.provider.MyMessageDigest;

public class MainClass {

	public void process() {
		MyMessageDigest  myProvider = new MyMessageDigest();
		MessageDigest messageDigest = myProvider.getProvider("SHA-256", "SunJCE");
		String alg = messageDigest.getProvider().getInfo();
//		messageDigest.
		System.out.println("alg "+ alg);
	}
	
	public static void main(String[] args) {
		new MainClass().process();
	}
	
}
