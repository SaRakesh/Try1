package com.jdk8.keystore;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.PrivateKey;

public class MyKeyStore {
	public static void main(String[] args) {
		MyKeyStore instance = new MyKeyStore();
		instance.process();
	}

	private void process() {
		File file = new File("e:/key");
		try {
			FileInputStream inputStream = new FileInputStream(file);
			if(!file.exists())
				return;
			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			keyStore.load(inputStream, "changeit".toCharArray());
			KeyStore.PasswordProtection protection = new KeyStore.PasswordProtection("changeit".toCharArray());
			KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("tomcat", protection);
			PrivateKey privateKey = privateKeyEntry.getPrivateKey();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
