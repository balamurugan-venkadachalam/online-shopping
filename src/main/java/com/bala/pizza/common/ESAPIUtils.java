package com.bala.pizza.common;

import org.owasp.esapi.ESAPI;

/**
 * 
 * @author engan.bala
 *
 */
public class ESAPIUtils {
	
	public static String  encodeURL(String url){
		return ESAPI.encoder().encodeForHTML(url);
	}

}
