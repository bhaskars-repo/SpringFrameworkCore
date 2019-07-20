/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Simple Hello Greeter
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework.service;

import com.polarsparc.springframework.data.WorldHelloDAO;

public class SimpleHelloGreeter implements HelloGreeter {
	private static String SPACE = " ";
	private static String STRANGER = "Stranger";
	
	private String separator = null;
	
	private WorldHelloDAO worldHello = null;
	
	public SimpleHelloGreeter() {
	}
	
	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public WorldHelloDAO getWorldHello() {
		return worldHello;
	}

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
