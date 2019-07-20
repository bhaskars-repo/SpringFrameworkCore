/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Simple Hello Greeter 4
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework.service;

import com.polarsparc.springframework.data.WorldHelloDAO;
import com.polarsparc.springframework.data.WorldSalesTax;

public class SimpleHelloGreeter4 implements HelloGreeter {
	private static int MAX_COUNT = 3;
	
	private static String SPACE = " ";
	private static String STRANGER = "Stranger";
	private static String SALES_TAX = "Sales Tax:";
	
	private int count = 0;
	
	private String separator = null;
	private String sep = null;
	
	private WorldHelloDAO worldHello = null;
	private WorldSalesTax worldSalesTax = null;
	
	public SimpleHelloGreeter4(Integer count, String sep, WorldSalesTax worldSalesTax) {
		if (count < 1) {
			this.count = count;
		}
		if (count > MAX_COUNT) {
			this.count = MAX_COUNT;
		}
		this.count = count;
		this.sep = sep;
		this.worldSalesTax = worldSalesTax;
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
			StringBuilder sb = new StringBuilder()
					               .append(worldHello.fetch(lang.toLowerCase()))
			                       .append(separator)
			                       .append(SPACE)
			                       .append(name)
			                       .append(SPACE);
			for (int i = 0; i < count; i++) {
				sb.append(sep);
			}
			msg = sb.append(SPACE)
					.append(SALES_TAX)
					.append(SPACE)
					.append(worldSalesTax.fetch(lang.toLowerCase()))
					.toString();
		}
		else {
			StringBuilder sb = new StringBuilder()
					               .append(worldHello.fetch(lang.toLowerCase()))
                                   .append(separator)
                                   .append(SPACE)
                                   .append(STRANGER)
                                   .append(SPACE);
			for (int i = 0; i < count; i++) {
				sb.append(sep);
			}
			msg = sb.append(SPACE)
					.append(SALES_TAX)
					.append(SPACE)
					.append(worldSalesTax.fetch(lang.toLowerCase()))
					.toString();
		}
		
		return msg;
	}
}
