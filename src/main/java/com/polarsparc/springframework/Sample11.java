/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 11
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.polarsparc.springframework.service.HelloGreeter;

public class Sample11 {
	private static Log LOG = LogFactory.getLog(Sample11.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =
			new GenericXmlApplicationContext("/sample9-beans.xml");
		
		HelloGreeter greeter = applicationContext.getBean("simpleHelloGreeterWithTax8", HelloGreeter.class);
		
		LOG.info(greeter.greetings("English", "Monkey"));
		LOG.info(greeter.greetings("Spanish", "Chimp"));
	}
}
