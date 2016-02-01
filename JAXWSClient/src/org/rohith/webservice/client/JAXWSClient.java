/**
 * 
 */
package org.rohith.webservice.client;

import org.rohith.webservice.HelloWorld;
import org.rohith.webservice.HelloWorldImplService;

/**
 * @author Rohith Srivardhan Reballi
 *
 */
public class JAXWSClient {

	public static void main(String[] args) {
		HelloWorldImplService helloWorldService = new HelloWorldImplService();
		HelloWorld helloWorld = helloWorldService.getHelloWorldImplPort();
		System.out.println(helloWorld.helloWorld("Rohith"));
		

	}

}
