package com.learning.teamtracker;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TeamTrackerApplication extends ResourceConfig {
	public TeamTrackerApplication() {
		
		JacksonJsonProvider json = new JacksonJsonProvider().
				configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).
				configure(SerializationFeature.INDENT_OUTPUT, true).
				configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		
		register(new TeamTrackerBinder());
		register(json);
		packages(true, "com.learning.teamtracker");
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}

}
