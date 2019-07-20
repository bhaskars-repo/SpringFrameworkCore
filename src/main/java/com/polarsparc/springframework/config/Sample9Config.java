/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 9 Config
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.polarsparc.springframework.data.SimpleFileWorldHelloDAO;
import com.polarsparc.springframework.data.WorldHelloDAO;
import com.polarsparc.springframework.service.HelloGreeter;
import com.polarsparc.springframework.service.SimpleHelloGreeter3;

@Configuration
public class Sample9Config {
	@Bean(initMethod="init", destroyMethod="destroy")
	public WorldHelloDAO simpleWorldHello(@Value("${env.csv.file:sample7.csv}") String filename) {
		SimpleFileWorldHelloDAO worldHello = new SimpleFileWorldHelloDAO();
		worldHello.setFileName(filename);
		
		return worldHello;
	}
	
	@Bean
	public HelloGreeter simpleHelloGreeter() {
		return new SimpleHelloGreeter3();
	}
}
