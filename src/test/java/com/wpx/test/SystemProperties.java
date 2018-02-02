package com.wpx.test;

public class SystemProperties {

	public static void main(String[] args) {
	
		System.getProperties().list(System.out);
		System.out.println("--------------");
		System.out.println("ÄãºÃ"+System.getProperty("line.separator")+"ÄãºÃ");
	}
}
