package com.test.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
@LocalBean
public class SingletonEJB {

	//some string K,V
	private Map<String, String> map = new HashMap<>();


	public SingletonEJB() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Singleton constructed <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}


	/* Utility methods */

	/** adds a new marker
	 * @param marker
	 * @return true if op is successful
	 */

	public Boolean addMarker(String marker) {

		map.put(marker, "dummy");
		System.out.println(">> put: key:" + marker + ", value: dummy");

		return true;
	}

	/** removes a marker
	 * @param marker
	 * @return
	 */

	public Boolean removeMarker(String marker) {


		if(map.containsKey(marker)) {
			map.remove(marker);
			System.out.println(">> removed: key:" + marker + ", value: dummy");
		}

		return true;
	}


	public void printMarkers() {

		System.out.println("Printing markers:");

		for(String key: map.keySet()) {
			System.out.println(">> " + map.get(key));
		}
		System.out.println("DONE printing markers:");
	}

	/* Getters and setters */



}
