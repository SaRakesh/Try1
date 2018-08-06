package com.jdk8.crypto.codeexample;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.DSAParameterSpec;

//In this example we will generate a public-private key pair 
//for the algorithm named "DSA" (Digital Signature Algorithm), 
//and use this keypair in future examples. We will generate 
//keys with a 1024-bit modulus. We don't care which provider 
//supplies the algorithm implementation.
public class KeyPairGeneratorExample {
	private KeyPair pair;

	public KeyPair getPair() {
		return pair;
	}

	public void setPair(KeyPair pair) {
		this.pair = pair;
	}

	public static void main(String[] args) {
		new KeyPairGeneratorExample().process();
	}

	public void process() {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
			/*
			 * All key pair generators share the concepts of a keysize and a
			 * source of randomness. The KeyPairGenerator class initialization
			 * methods at a minimum needs a keysize. If the source of randomness
			 * is not explicitly provided, a SecureRandom implementation of the
			 * highest-priority installed provider will be used. Thus to
			 * generate keys with a keysize of 1024, simply call:
			 */

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
			secureRandom.setSeed(SecureRandom.getSeed(64));
			String p = "";
			String q = "";
			String g = "";
			// Algorithm-Specific Initialization
			DSAParameterSpec dsaParameterSpec = new DSAParameterSpec(new BigInteger(p), new BigInteger(q),
					new BigInteger(g));
			keyPairGenerator.initialize(dsaParameterSpec, secureRandom);
			pair = keyPairGenerator.generateKeyPair();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
