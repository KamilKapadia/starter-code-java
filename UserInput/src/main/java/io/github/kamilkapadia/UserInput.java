package io.github.kamilkapadia;

import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("**************************************************************");
		System.out.println("********** Working With User Input Programmatically **********");
		System.out.println("**************************************************************");
		System.out.println();
		
		System.out.println("===== Input from Command Line Args =====");
		if (args.length > 0) {
			for (String arg : args) {
				System.out.println(arg);
			}
		} else {
			System.out.println("No command line args found");
		}
	
		System.out.println();
		System.out.println("===== Input from prompts =====");
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter your name: ");
			String name = scanner.nextLine();
			System.out.println("Hello " + name);
		}
		
		System.out.println();
		
	}
}
