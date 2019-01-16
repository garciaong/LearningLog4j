package com.log4j.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTester {

	private static final Logger log = Logger.getLogger(Log4jTester.class);
	private static Properties prop = new Properties();
	
	public static void main(String [] args) {
		try {
			FileInputStream inputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "/config/config.properties"));
			prop.load(inputStream);
			initialization();
			//All,TRACE,DEBUG,INFO,WARN,ERROR,FATAL,OFF
			log.trace("This is a trace log");
			log.info("This is a info log");
			log.error("This is a error log");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void initialization() throws FileNotFoundException, IOException {
		Properties logProp = new Properties();
		 
        //Loading log4j properties configuration file
		logProp.load(new FileInputStream(prop.getProperty("log4j.directory")));
        PropertyConfigurator.configure(logProp);
	}
}
