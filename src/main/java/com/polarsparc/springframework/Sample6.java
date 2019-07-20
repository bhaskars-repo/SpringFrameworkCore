/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 6
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.polarsparc.springframework.config.Sample6Config;
import com.polarsparc.springframework.service.HelloGreeter;

public class Sample6 {
	private static Log LOG = LogFactory.getLog(Sample6.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =
			new AnnotationConfigApplicationContext(Sample6Config.class);
		
		HelloGreeter greeter = applicationContext.getBean("simpleHelloGreeter", HelloGreeter.class);
		
		LOG.info(greeter.greetings("french", "Panther"));
		LOG.info(greeter.greetings("English", "Lion"));
	}
}
