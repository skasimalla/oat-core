package com.atomicitysystems.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

public class FileUtil {
	public static FileUtil o;

	public static FileUtil getInstance() {
		if (o == null) {
			o = new FileUtil();
		}
		return o;
	}

	private final static Logger LOGGER = Logger.getLogger(FileUtil.class.getName());

	public static void main(String[] args) {
		LOGGER.info(FileUtil.getInstance().getProp("accept_url"));
	}

	public String readFile(String fileName) {
		//InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
		String theString="" ;
		try {
		InputStream is = new FileInputStream(new File(fileName));
		StringWriter writer = new StringWriter();
		
			IOUtils.copy(is, writer, "UTF-8");
		theString = writer.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return theString;
	}

	public String getProp(String propName) {
		//String path = System.getProperty("user.home") + "/" + Constants.appBaseFolder + "/" + Constants.propsFile;
		//LOGGER.info(path);
		Properties prop = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(Constants.propsFile);
			//is = getClass().getClassLoader().getResourceAsStream(Constants.propsFile);
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// get the property value and print it out
		return prop.getProperty(propName);
	}

	public void writeToFile(String share_location, String txnNumber, String result) {
		// Write this string to file.
		PrintWriter writer;
		try {
			File file = new File(share_location + txnNumber + ".txt");
			LOGGER.info("Writing to file" + share_location + txnNumber + ".txt");
			writer = new PrintWriter(file, "UTF-8");
			writer.println("The first line");
			writer.println(result);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBaseLocation() {
		if (FileUtil.getInstance().getProp("baseLocation").equals("home"))
			return System.getProperty("user.home") + FileUtil.getInstance().getProp("share_location");
		else
			return FileUtil.getInstance().getProp("share_location");
	}
}
