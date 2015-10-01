/**
 *
 */
package com.test.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * @author mihai
 *
 */

@Stateless
@Path(DocumentRestService.RESOURCE_PATH)
public class DocumentRestService {

	public static final String RESOURCE_PATH = "document";


	@EJB
	private SingletonEJB userAuth;


	@GET
	@Path("/test")
	public Response test() {

		if(userAuth==null) {
			System.out.println("Singleton is null inside document. ");
			return Response.ok("injection failed").build();
		}


		//insert something
		userAuth.addMarker("doc_marker");
		//print what we have in the singleton
		userAuth.printMarkers();


		return Response.ok("injection success").build();
	}


}