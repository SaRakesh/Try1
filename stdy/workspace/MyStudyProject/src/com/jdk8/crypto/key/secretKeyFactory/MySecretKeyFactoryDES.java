package com.jdk8.crypto.key.secretKeyFactory;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class MySecretKeyFactoryDES {
	public static void main(String[] args) {
		MySecretKeyFactoryDES instance = new MySecretKeyFactoryDES();
		instance.process();
		instance.process1();
	}

	private void process1() {
		byte[] deseKeyData = { (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
				(byte) 0x07, (byte) 0x08 };
		SecretKeySpec secretKeySpec = new SecretKeySpec(deseKeyData, "DES");
		System.out.println("process1 secretKeySpec " + secretKeySpec.getFormat());

	}

	public void process() {
		try {
			byte[] deseKeyData = { (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
					(byte) 0x07, (byte) 0x08 };
			DESKeySpec desKeySpec = new DESKeySpec(deseKeyData);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			// If you have a key specification for a secret key, you can obtain
			// an opaque SecretKey object from the specification by using the
			// generateSecret method:
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			System.out.println("process secretKey " + secretKey.getFormat());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
