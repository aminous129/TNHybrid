package com.tutorial.qa.utils;

import java.util.Date;

public class Utilities {
  
	public  static String generateEmailWithTimeStamp() {
 
	 Date date= new Date();
	 String timeStamp=date.toString().replace(" ", "_").replace(":", "_");
	 return "brik" + timeStamp + "@gmail.com";
 }
	public  static String generateNameforEmailWithTimeStamp() {
		 
		 Date date= new Date();
		 String timeStamp=date.toString().replace(" ", "_").replace(":", "_").substring(8,19).replace("_", "");
		 return "brik" + timeStamp + "@gmail.com";
	 }
	public static final int implitiWaitTime=10;
	public static final int pageLoadTime=10;
	public static final int scriptTimeOut=100;
}
