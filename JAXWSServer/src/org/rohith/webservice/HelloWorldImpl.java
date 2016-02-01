/**
 * 
 */
package org.rohith.webservice;

import javax.jws.WebService;

/**
 * @author Rohith Srivardhan Reballi
 *
 */
@WebService(endpointInterface="org.rohith.webservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
	
	public String helloWorld(String name){
		return "Hello World from :"+name;
	}

}
