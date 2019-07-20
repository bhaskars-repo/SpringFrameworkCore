/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 10
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.polarsparc.springframework.service.HelloGreeter;

public class Sample10 {
	private static Log LOG = LogFactory.getLog(Sample10.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("/sample8-beans.xml");
		
		HelloGreeter greeter = applicationContext.getBean("simpleHelloGreeter", HelloGreeter.class);
		
		LOG.info(greeter.greetings("german", "Eagle"));
		LOG.info(greeter.greetings("italian", "Goose"));
	}
}
