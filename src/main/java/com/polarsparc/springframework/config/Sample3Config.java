/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 3 Config
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.polarsparc.springframework.data.SimpleMemoryWorldHelloDAO;
import com.polarsparc.springframework.data.WorldHelloDAO;
import com.polarsparc.springframework.service.HelloGreeter;
import com.polarsparc.springframework.service.SimpleHelloGreeter3;

@Configuration
public class Sample3Config {
	@Bean
	public WorldHelloDAO simpleWorldHello() {
		return new SimpleMemoryWorldHelloDAO();
	}
	
	@Bean
	public HelloGreeter simpleHelloGreeter() {
		return new SimpleHelloGreeter3();
	}
}
