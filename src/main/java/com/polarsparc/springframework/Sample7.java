/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 7
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

public class Sample7 {
	private static Log LOG = LogFactory.getLog(Sample7.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("/sample7-beans.xml");
		
		HelloGreeter greeter = applicationContext.getBean("simpleHelloGreeter", HelloGreeter.class);
		
		LOG.info(greeter.greetings("German", "Alligator"));
		LOG.info(greeter.greetings("French", "Bear"));
		
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}
