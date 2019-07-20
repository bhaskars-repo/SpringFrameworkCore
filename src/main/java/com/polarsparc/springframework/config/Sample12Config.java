/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 12 Config
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.polarsparc.springframework.data.SimpleMemoryWorldHelloDAO;
import com.polarsparc.springframework.data.SimpleMemoryWorldSalesTaxDAO3;
import com.polarsparc.springframework.data.WorldHelloDAO;
import com.polarsparc.springframework.data.WorldSalesTax;
import com.polarsparc.springframework.service.HelloGreeter;
import com.polarsparc.springframework.service.SimpleHelloGreeter6;

@Configuration
@PropertySource("classpath:sample5.properties")
public class Sample12Config {
	@Autowired
	private Environment env;
	
	@Bean
	public WorldHelloDAO simpleWorldHello() {
		return new SimpleMemoryWorldHelloDAO();
	}
	
	@Bean
	public HelloGreeter simpleHelloGreeter() {
		Integer sepCount = env.getProperty("prop.sep.count", Integer.class);
		
		String sepChar = env.getProperty("prop.sep.char");
		String greeterSep = env.getProperty("prop.greeter.sep");
		
		WorldSalesTax worldSalesTax = SimpleMemoryWorldSalesTaxDAO3.getInstance();
		
		SimpleHelloGreeter6 greeter = new SimpleHelloGreeter6(sepCount, sepChar, worldSalesTax);
		greeter.setSeparator(greeterSep);
		
		return greeter;
	}
}
