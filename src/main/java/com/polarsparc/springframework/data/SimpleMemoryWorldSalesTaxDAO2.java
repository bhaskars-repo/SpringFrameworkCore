/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Simple Memory World Sales Tax DAO 2
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

@Repository
public class SimpleMemoryWorldSalesTaxDAO2 implements WorldSalesTax {
	private static Log LOG = LogFactory.getLog(SimpleMemoryWorldSalesTaxDAO2.class);
	
	private Map<String, Float> salesTaxByState = null;
	
	public SimpleMemoryWorldSalesTaxDAO2() {
		salesTaxByState = Stream.of(new String[][] {
			{ "english", "20.0" },
			{ "french", "20.0" },
			{ "german", "19.0" },
			{ "italian", "22.0" },
			{ "spanish", "21.0" }
		}).collect(Collectors.toMap(str -> str[0], str -> Float.valueOf(str[1])));
		
		LOG.info("Initialized a new instance of SimpleMemoryWorldSalesTaxDAO2");
	}
	
	@Override
	public float fetch(String lang) {
		if (lang != null && lang.trim().isEmpty() == false) {
			return salesTaxByState.getOrDefault(lang.toLowerCase(), 10.0f);
		}
		
		return 15.0f;
	}
}
