package io.github.kamilkapadia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFiles {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("**************************************************************");
		System.out.println("********* Working With Config Files Programmatically *********");
		System.out.println("**************************************************************");
		System.out.println();

		System.out.println("===== Properties from: config.properties =====");
		printProperties("config.properties");

		
		System.out.println("========= Properties from: config.xml =========");
		printXmlProperties("config.xml");
	}

	private static void printProperties(String fileName) {
		try (InputStream input = ConfigFiles.class.getClassLoader().getResourceAsStream(fileName)) { 
			Properties props = new Properties();
			props.load(input);
			
			System.out.printf("userame  =  %s%n", props.getProperty("username"));
			System.out.printf("url      =  %s%n", props.getProperty("url"));
			System.out.printf("port     =  %s%n", props.getProperty("port"));
			
		} catch (IOException ex) {
			System.err.println("ERROR with reading properties file: " + ex.getMessage());
		}
		
		System.out.println();
	}
	
	private static void printXmlProperties(String fileName) {
		try (InputStream input = ConfigFiles.class.getClassLoader().getResourceAsStream(fileName)) { 
			Properties props = new Properties();
			props.loadFromXML(input);
						
			System.out.printf("userame  =  %s%n", props.getProperty("username"));
			System.out.printf("url      =  %s%n", props.getProperty("url"));
			System.out.printf("port     =  %s%n", props.getProperty("port"));
			
		} catch (IOException ex) {
			System.err.println("ERROR with reading properties file: " + ex.getMessage());
		}
		
		System.out.println();
	}
}
