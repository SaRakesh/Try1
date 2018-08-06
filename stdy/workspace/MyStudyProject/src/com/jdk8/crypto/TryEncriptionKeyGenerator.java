package com.jdk8.crypto;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class TryEncriptionKeyGenerator {
	byte[] key;
	public static void main(String[] args) {
		TryEncriptionKeyGenerator instance = new TryEncriptionKeyGenerator();
		instance.encrypt();
	}

	private void encrypt() {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("AES");
			generator.init(256);
			key = generator.generateKey().getEncoded();
			SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			byte[] ciphertext = cipher.doFinal("Hello, World!".getBytes("UTF-8"));
			String encrypt = Base64.getEncoder().encodeToString(ciphertext);
			System.out.println(encrypt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
