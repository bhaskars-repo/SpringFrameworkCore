/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 4
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

public class Sample4 {
	private static Log LOG = LogFactory.getLog(Sample4.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("/sample3-beans.xml");
		
		HelloGreeter greeter = applicationContext.getBean("simpleHelloGreeter", HelloGreeter.class);
		
		LOG.info(greeter.greetings("spanish", "Duck"));
		LOG.info(greeter.greetings("french", "Snake"));
	}
}
