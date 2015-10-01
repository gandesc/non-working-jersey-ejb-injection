package com.test;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.test.rest.SingletonEJB;

@ApplicationPath("myapp")
public class JerseyApp extends ResourceConfig {

  public JerseyApp() {

	  register(JacksonFeature.class);
      register(SingletonEJB.class);

	  // Register resources and providers using package-scanning.
      packages("com.test.rest");

      // Register my custom provider - not needed if it's in my.package.
      //register(SecurityRequestFilter.class);
      // Register an instance of LoggingFilter.
      //register(new LoggingFilter(LOGGER, true));

      // Enable Tracing support.
      property(ServerProperties.TRACING, "ALL");

  }

}