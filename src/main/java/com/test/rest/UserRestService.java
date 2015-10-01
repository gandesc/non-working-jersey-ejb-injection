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
@Path(UserRestService.RESOURCE_PATH)
public class UserRestService {

	public static final String RESOURCE_PATH = "user";

	@EJB
	private SingletonEJB userAuth;

	public UserRestService() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Path("/test")
	public Response test() {

		if(userAuth==null) {
			System.out.println("Singleton is null inside user. Can't add anything.");
			return Response.ok("injection failed").build();
		}

		//insert something
		userAuth.addMarker("user_marker");
		//print what we have in the singleton
		userAuth.printMarkers();


		return Response.ok().build();
	}

}
