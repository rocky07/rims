package com.forsfortis.rims.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerConfig {
	private static ServerConfig instance=null;
	private static String REMOTE_HOST="remote_host";
	
	//instance variables
	
	private String remoteHost;
	
	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	private ServerConfig() {
		// TODO Auto-generated constructor stub
		load();
	}
	
	public static ServerConfig getInstance(){
		if(instance == null){
			instance=new ServerConfig();
		}
		return instance;
	}
	public void load(){
		Properties prop = new Properties();
	    try {
	    	final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("server.properties");
			prop.load(resourceAsStream);
			
			//sets the variable values
			setRemoteHost(prop.getProperty(REMOTE_HOST));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
