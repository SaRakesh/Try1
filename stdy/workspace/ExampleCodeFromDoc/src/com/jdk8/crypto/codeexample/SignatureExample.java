package com.jdk8.crypto.codeexample;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;

public class SignatureExample {
	public static void main(String[] args) {
		new SignatureExample().process();
	}

	private void process() {
		KeyPairGeneratorExample keyPairGenerator = new KeyPairGeneratorExample();
		KeyPair keyPair = keyPairGenerator.getPair();
		PrivateKey privateKey = keyPair.getPrivate();
		try {
			Signature dsa = Signature.getInstance("SHA1withDSA");
			dsa.initSign(privateKey);
			byte[] data = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74 };
			dsa.update(data);
			byte[] sig = dsa.sign();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
