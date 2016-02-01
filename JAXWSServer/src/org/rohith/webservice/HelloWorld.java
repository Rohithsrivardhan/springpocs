/**
 * 
 */
package org.rohith.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Rohith Srivardhan Reballi
 *
 */
@WebService
public interface HelloWorld {
   
	@WebMethod
	public String helloWorld(String name);
}
