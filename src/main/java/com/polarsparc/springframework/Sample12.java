/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 12
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

import com.polarsparc.springframework.config.Sample12Config;
import com.polarsparc.springframework.service.HelloGreeter;

public class Sample12 {
	private static Log LOG = LogFactory.getLog(Sample12.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext =
			new AnnotationConfigApplicationContext(Sample12Config.class);
		
		HelloGreeter greeter = applicationContext.getBean("simpleHelloGreeter", HelloGreeter.class);
		
		LOG.info(greeter.greetings("German", "Dragon"));
		LOG.info(greeter.greetings("Italian", "Mongoose"));
		
		((AnnotationConfigApplicationContext)applicationContext).close();
	}
}
