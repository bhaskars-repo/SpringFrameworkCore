/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Simple Memory World Hello DAO 3
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework.data;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository("worldHello")
public class SimpleMemoryWorldHelloDAO3 implements WorldHelloDAO {
	private static Log LOG = LogFactory.getLog(SimpleMemoryWorldHelloDAO3.class);
	
	private Map<String, String> helloByLang = null;
	
	public SimpleMemoryWorldHelloDAO3() {
		helloByLang = Stream.of(new String[][] {
			{ "english", "HELLO" },
			{ "french", "BONJOUR" },
			{ "german", "GUTEN TAG" },
			{ "italian", "SALVE" },
			{ "spanish", "HOLA" }
		}).collect(Collectors.toMap(str -> str[0], str -> str[1]));
		
		LOG.info("Initialized a new instance of SimpleMemoryWorldHelloDAO3");
	}
	
	@Override
	public String fetch(String lang) {
		String msg = null;
		
		if (lang != null && lang.trim().isEmpty() == false) {
			msg = helloByLang.get(lang.toLowerCase());
		}
		
		if (msg == null) {
			msg = helloByLang.get("english");
		}
		
		return msg;
	}
}
