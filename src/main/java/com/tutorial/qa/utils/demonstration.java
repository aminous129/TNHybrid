package com.tutorial.qa.utils;

public class demonstration {
 
	public static void main (String[] args) {
		System.getProperties().list(System.out);
		
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.version"));
	}
	
}
