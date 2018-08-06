package com.jdk8.crypto.key.KeyGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStore.SecretKeyEntry;
import java.security.PrivateKey;
import java.util.Enumeration;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class MyKeystore {
	public static void main(String[] args) {
		MyKeystore instance = new MyKeystore();
		instance.readKeyEntry();
	}

	private void readKeyEntry() {
		File file = new File("e:/key");
		if (file.exists()) {
			try {
				KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
				keyStore.load(new FileInputStream(file), "changeit".toCharArray());
				if(keyStore.isKeyEntry("tomcat")){
					System.out.println("tomcate alise is there");
					Key key = keyStore.getKey("tomcat", "changeit".toCharArray());
					System.out.println(key.getFormat());
					KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection("changeit".toCharArray());
					KeyStore.PrivateKeyEntry entry = (KeyStore.PrivateKeyEntry)keyStore.getEntry("tomcat", protParam);
					PrivateKey privateKey = entry.getPrivateKey();
					
					//ADD NEW ENTRY
					SecretKey secretKey = generateKey();
					SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
					keyStore.setEntry("entry1", secretKeyEntry, protParam);
					FileOutputStream outputStream = new FileOutputStream(new File("e:/key1"));
					keyStore.store(outputStream, "changeit".toCharArray());
					 
				}else if(keyStore.isCertificateEntry("tomcat")){
					System.out.println("tomcate certificate is there");
				}
				Enumeration<String> enumeration = keyStore.aliases();
				while (enumeration.hasMoreElements()) {
					String element = (String) enumeration.nextElement();
//					enumeration.
					System.out.println(element);
					
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}
	public SecretKey generateKey() {
		SecretKey secretKey = null;
		try {
			byte[] deseKeyData = { (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
					(byte) 0x07, (byte) 0x08 };
			DESKeySpec desKeySpec = new DESKeySpec(deseKeyData);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			secretKey = keyFactory.generateSecret(desKeySpec);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return secretKey;
	}
}
