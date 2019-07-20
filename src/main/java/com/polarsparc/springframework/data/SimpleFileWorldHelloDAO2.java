/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Simple File World Hello DAO 2
 * 
 * Author: Bhaskar S
 * 
 * URL:    https://www.polarsparc.com
 */

package com.polarsparc.springframework.data;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("fileWorldHello")
public class SimpleFileWorldHelloDAO2 implements WorldHelloDAO {
	private static String COMMA = ",";
	
	private static Log LOG = LogFactory.getLog(SimpleFileWorldHelloDAO2.class);
	
	private String fileName = null;
	
	private Map<String, String> helloByLang = null;
	
	private Stream<String> stream = null;
	
	public SimpleFileWorldHelloDAO2() {
		LOG.info("Created new instance of SimpleFileWorldHelloDAO");
	}
	
	public String getFileName() {
		return fileName;
	}

	@Value("${env.csv.file:sample7.csv}")
	public void setFileName(String filename) {
		this.fileName = filename;
	}

	@PostConstruct
	public void init() throws Exception {
		LOG.info("Initializing cache from the file " + fileName);
		
		Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
		
		stream = Files.lines(path);
		
		helloByLang = stream.map(line -> line.split(COMMA))
			                .collect(Collectors.toMap(tokens -> tokens[0].toLowerCase(), 
			                    		              tokens -> tokens[1]));
		
		LOG.info("Cache successfully initialized with " + helloByLang.toString());
	}
	
	@PreDestroy
	public void destroy() {
		LOG.info("Closing the stream resource");
		
		if (stream != null) {
			stream.close();
		}
		
		LOG.info("Successfully closed the stream resource");
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
