package io.github.kamilkapadia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class RegularExpressions {

	private static Properties props;

	public static void main(String[] args) throws IOException {
		System.out.println();
		System.out.println("*****************************************************************");
		System.out.println("******* Working With Regular Expressions Programmatically *******");
		System.out.println("*****************************************************************");
		System.out.println();

		loadProperties();

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("========== Phone Number Pattern Validation ===========");
			String phoneRegex = props.getProperty("phoneNumber.regex");
			System.out.printf("Regular Expression: %s%n%n", phoneRegex);
			System.out.println("Please enter a phone number: ");
			String phoneNumber = scanner.nextLine();
			System.out.printf("Phone number: %s is %s%n%n", phoneNumber, checkValue(phoneNumber, phoneRegex));
			
			System.out.println("========== Email Address Pattern Validation ==========");
			String emailRegex = props.getProperty("emailAddress.regex");
			System.out.printf("Regular Expression: %s%n%n", emailRegex);
			System.out.println("Please enter an Email address: ");
			String emailAddress = scanner.nextLine();
			System.out.printf("Email address: %s is %s%n%n", emailAddress, checkValue(emailAddress, emailRegex));

			System.out.println("=============== URL Pattern Validation ===============");
			String urlRegex = props.getProperty("url.regex");
			System.out.printf("Regular Expression: %s%n%n", urlRegex);
			System.out.println("Please enter a URL: ");
			String url = scanner.nextLine();
			System.out.printf("The URL: %s is %s%n%n", url,	checkValue(url, urlRegex));
		}
	}

	private static void loadProperties() throws IOException {
		try (InputStream input = RegularExpressions.class.getClassLoader().getResourceAsStream("config.properties")) {
			props = new Properties();
			props.load(input);
		}
	}

	private static String checkValue(String value, String regex) {
		return value.matches(regex) ? "VALID" : "NOT valid";
	}
}
