package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	 public ConfigReader()
	{
		try {
			FileInputStream scr=new FileInputStream("./Configuration/config.properties");
			prop=new Properties();
			prop.load(scr);
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public String getApplicationURL() {
		String url=prop.getProperty("baseurl");
		return url;
	}
	
	public String getUser() {
		String user=prop.getProperty("user");
		return user;
	}
	
	public String getPassword() {
		String pass=prop.getProperty("password");
		return pass;
	}
	public String getChromePath() {
		String path=prop.getProperty("chromepath");
		return path;
	}
	
	public String getFirefoxPath() {
		String firefoxpath=prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getEdgePath() {
		String edgepath=prop.getProperty("edgepath");
		return edgepath;
	}
}
