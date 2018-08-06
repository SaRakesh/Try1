package com.jdk8.crypto.codeexample;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class EncryptionExampleCode {
	private String pass = "Impelsys123";
	private String key;
	private String encypass;
	private int count = 1000;
	private byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c, (byte) 0x7e, (byte) 0xc8, (byte) 0xee,
			(byte) 0x99 };

	public static void main(String[] args) {
		EncryptionExampleCode instance = new EncryptionExampleCode();
		instance.encr();
	}

	private void encr() {
		try {
			Cipher pbeCipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_256");
			PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, count);

			PBEKeySpec pbeKeySpec = new PBEKeySpec(pass.toCharArray());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_256");
			SecretKey secretKey = keyFactory.generateSecret(pbeKeySpec);
			pbeCipher.init(Cipher.ENCRYPT_MODE, secretKey, pbeParamSpec);
			byte[] clearText = "some text i dont know why".getBytes();
			byte[] cipherText = pbeCipher.doFinal(clearText);
			key = Base64.getEncoder().encodeToString(cipherText);
			System.out.println("key " + key);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
