/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Simple Memory World Sales Tax DAO 3
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

public enum SimpleMemoryWorldSalesTaxDAO3 implements WorldSalesTax {
	INSTANCE;
	
	private Log LOG = LogFactory.getLog(SimpleMemoryWorldSalesTaxDAO3.class);
	
	private Map<String, Float> salesTaxByState = null;
	
	public static WorldSalesTax getInstance() {
		INSTANCE.LOG.info("Fetching the instance of WorldSalesTax");
		
		return INSTANCE;
	}
	
	private SimpleMemoryWorldSalesTaxDAO3() {
		salesTaxByState = Stream.of(new String[][] {
			{ "english", "10.0" },
			{ "french", "15.0" },
			{ "german", "20.0" },
			{ "italian", "25.0" },
			{ "spanish", "30.0" }
		}).collect(Collectors.toMap(str -> str[0], str -> Float.valueOf(str[1])));
		
		LOG.info("Initialized a new instance of SimpleMemoryWorldSalesTaxDAO3");
	}
	
	@Override
	public float fetch(String lang) {
		if (lang != null && lang.trim().isEmpty() == false) {
			return salesTaxByState.getOrDefault(lang.toLowerCase(), 10.0f);
		}
		
		return 15.0f;
	}
}
