/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Simple Hello Greeter 3
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.polarsparc.springframework.data.WorldHelloDAO;

public class SimpleHelloGreeter3 implements HelloGreeter {
	private static String SPACE = " ";
	private static String STRANGER = "Stranger";
	
	private String separator = null;
	
	private WorldHelloDAO worldHello = null;
	
	public SimpleHelloGreeter3() {
	}
	
	public String getSeparator() {
		return separator;
	}

	@Value("${env.greeter.sep:-}")
	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public WorldHelloDAO getWorldHello() {
		return worldHello;
	}

	@Autowired
	public void setWorldHello(WorldHelloDAO worldHello) {
		this.worldHello = worldHello;
	}

	@Override
	public String greetings(String lang, String name) {
		String msg = null;
		
		if (name != null && name.trim().isEmpty() == false) {
			msg = new StringBuilder()
					  .append(worldHello.fetch(lang.toLowerCase()))
					  .append(separator)
					  .append(SPACE)
					  .append(name)
					  .toString();
		}
		else {
			msg = new StringBuilder()
					  .append(worldHello.fetch(lang.toLowerCase()))
					  .append(separator)
					  .append(SPACE)
					  .append(STRANGER)
					  .toString();
		}
		
		return msg;
	}
}
