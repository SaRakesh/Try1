package com.jdk8.crypto.cipher;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class Try1DECRYPT_MODE {

	SecretKey myKey;
	byte[] myAAD;
	byte[] plainText;
	int myTLen;
	byte[] myIv;
	private String password = "password";
	private SecureRandom secureRandom;

	public Try1DECRYPT_MODE() {
		try {
			secureRandom = SecureRandom.getInstanceStrong();
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128, secureRandom);
			myKey = keyGen.generateKey();
			plainText = password.getBytes();
			myTLen = 16 * 8;
			myIv = new byte[12];
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Try1DECRYPT_MODE().process();
	}

	private void process() {

		try {
			secureRandom.nextBytes(myIv);
			GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(myTLen, myIv);
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, myKey, gcmParameterSpec);
			byte[] cipherText = new byte[cipher.getOutputSize(cipher.getBlockSize())];
			cipher.doFinal(plainText, 0, plainText.length, cipherText);
			String result = Base64.getEncoder().encodeToString(cipherText);
			System.out.println("result " + result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
