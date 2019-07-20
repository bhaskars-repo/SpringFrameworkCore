/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 2
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

public class Sample2 {
	private static Log LOG = LogFactory.getLog(Sample2.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =
			new GenericXmlApplicationContext("/sample2-beans.xml");
		
		HelloGreeter greeter = applicationContext.getBean("simpleHelloGreeter", HelloGreeter.class);
		
		LOG.info(greeter.greetings("English", "Cat"));
		LOG.info(greeter.greetings("German", "Tiger"));
	}
}
