package com.jdk8.crypto.codeexample;

import java.security.MessageDigest;

public class MessageDigestExample {
	public static void main(String[] args) {
		new MessageDigestExample().process();
	}

	private void process() {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			byte[] i1={ (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x04, (byte) 0x05, (byte) 0x06,
					(byte) 0x07, (byte) 0x08 };
			byte[] i2={ (byte) 0x11, (byte) 0x12, (byte) 0x13, (byte) 0x14, (byte) 0x15, (byte) 0x16,
					(byte) 0x17, (byte) 0x18 };
			byte[] i3={ (byte) 0x21, (byte) 0x22, (byte) 0x23, (byte) 0x24, (byte) 0x25, (byte) 0x26,
					(byte) 0x27, (byte) 0x28 };
			byte[] i4={ (byte) 0x31, (byte) 0x32, (byte) 0x33, (byte) 0x34, (byte) 0x35, (byte) 0x36,
					(byte) 0x37, (byte) 0x38 };
			messageDigest.update(i1);
			byte[] i1Hash = ((MessageDigest) messageDigest.clone()).digest();
			
			messageDigest.update(i2);
			byte[] i2Hash = ((MessageDigest) messageDigest.clone()).digest();
			
			messageDigest.update(i3);
			byte[] i3Hash = ((MessageDigest) messageDigest.clone()).digest();
			
			messageDigest.update(i4);
			byte[] i4Hash = ((MessageDigest) messageDigest.clone()).digest();
			
			print(i1Hash);
			print(i2Hash);
			print(i3Hash);
			print(i4Hash);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	private void print(byte[] hash) {
		System.out.println("========================="+hash.length);
		for(int i=0; i<hash.length; i++){
			System.out.print(" "+hash[i]);
		}
		System.out.println();
		
	}
}
