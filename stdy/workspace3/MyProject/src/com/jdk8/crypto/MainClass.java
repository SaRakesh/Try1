package com.jdk8.crypto;

import java.security.MessageDigest;

import com.jdk8.crypto.provider.MyProvider;

public class MainClass {

	public MainClass() {
		MyProvider  myProvider = new MyProvider();
		MessageDigest messageDigest = myProvider.getProvider("MD5", "");
		String alg = messageDigest.getAlgorithm();
		System.out.println("alg "+ alg);
	}
}
