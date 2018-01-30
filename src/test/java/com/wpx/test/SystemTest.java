package com.wpx.test;


import java.util.Scanner;

public class SystemTest {

	public static void main(String[] args) {
	
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				String string = scanner.nextLine();
				System.out.println("ÄúÊäÈëµÄÎª "+ string);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
