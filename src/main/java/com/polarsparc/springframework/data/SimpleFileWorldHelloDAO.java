/*
 * Topic:  Spring Framework Core Essentials
 * 
 * Name:   Simple File World Hello DAO
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleFileWorldHelloDAO implements WorldHelloDAO {
	private static String COMMA = ",";
	
	private static Log LOG = LogFactory.getLog(SimpleFileWorldHelloDAO.class);
	
	private String fileName = null;
	
	private Map<String, String> helloByLang = null;
	
	private Stream<String> stream = null;
	
	public SimpleFileWorldHelloDAO() {
		LOG.info("Created new instance of SimpleFileWorldHelloDAO");
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String filename) {
		this.fileName = filename;
	}

	public void init() throws Exception {
		LOG.info("Initializing cache from the file " + fileName);
		
		Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
		
		stream = Files.lines(path);
		
		helloByLang = stream.map(line -> line.split(COMMA))
			                .collect(Collectors.toMap(tokens -> tokens[0].toLowerCase(), 
			                    		              tokens -> tokens[1]));
		
		LOG.info("Cache successfully initialized with " + helloByLang.toString());
	}
	
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
