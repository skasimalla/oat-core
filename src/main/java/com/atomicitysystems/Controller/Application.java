package com.atomicitysystems.Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	private final static Logger LOGGER = Logger.getLogger(Application.class.getName());
	public static void main(String[] args) {
		InetAddress ip;
		try {
				SpringApplication.run(Application.class, args);//Remove this line in version 2 
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}