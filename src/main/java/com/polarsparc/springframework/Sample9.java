/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 9
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

import com.polarsparc.springframework.config.Sample9Config;
import com.polarsparc.springframework.service.HelloGreeter;

public class Sample9 {
	private static Log LOG = LogFactory.getLog(Sample9.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext =
			new AnnotationConfigApplicationContext(Sample9Config.class);
		
		HelloGreeter greeter = applicationContext.getBean("simpleHelloGreeter", HelloGreeter.class);
		
		LOG.info(greeter.greetings("french", "Dog"));
		LOG.info(greeter.greetings("italian", "Snake"));
		
		((AnnotationConfigApplicationContext)applicationContext).close();
	}
}
