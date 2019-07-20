/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Sample 8
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

public class Sample8 {
	private static Log LOG = LogFactory.getLog(Sample8.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext =
			new GenericXmlApplicationContext("/sample2-beans.xml");
		
		HelloGreeter greeter = applicationContext.getBean("fileHelloGreeter", HelloGreeter.class);
		
		LOG.info(greeter.greetings("English", "Zebra"));
		LOG.info(greeter.greetings("Spanish", "Mule"));
		
		((GenericXmlApplicationContext)applicationContext).close();
	}
}
