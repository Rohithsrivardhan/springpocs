/**
 * 
 */
package org.rohith.webservice;

import javax.xml.ws.Endpoint;

/**
 * @author Rohith Srivardhan Reballi
 *
 */
public class HelloWorldWSPublisher {

	
	public static void main(String[] args) {
       Endpoint.publish("http://localhost:8080/WS/HelloWorld", new HelloWorldImpl());
		
	}

}
