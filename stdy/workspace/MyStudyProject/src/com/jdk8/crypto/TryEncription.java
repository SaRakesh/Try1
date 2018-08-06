package com.jdk8.crypto;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class TryEncription {

	byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c, (byte) 0x7e, (byte) 0xc8, (byte) 0xee,
			(byte) 0x99 };
	byte[] iv;
	public static void main(String[] args) {
		TryEncription instance = new TryEncription();
		instance.encrypt();
		instance.decrypt();
	}

	private void decrypt() {
		// TODO Auto-generated method stub

	}

	private void encrypt() {
		try {
			KeySpec spec = new PBEKeySpec("password".toCharArray(), salt,  65536, 256);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			SecretKey temp = factory.generateSecret(spec);
			SecretKey secret = new SecretKeySpec(temp.getEncoded(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secret);
			iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
			byte[] ciphertext = cipher.doFinal("Hello, World!".getBytes("UTF-8"));
			String encrypt = Base64.getEncoder().encodeToString(ciphertext);
			System.out.println(encrypt);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
