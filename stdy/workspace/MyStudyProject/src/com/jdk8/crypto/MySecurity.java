package com.jdk8.crypto;

import java.security.Provider;
import java.security.Security;

public class MySecurity {

	public static void main(String[] args) {
		Provider[] providers = Security.getProviders();
		for(Provider provider : providers){
			System.out.println(provider.getName());
		}
		System.out.println("++++++++++++++++++++++++");
		System.out.println(Security.getProperty("security.provider.2"));
	}
}
