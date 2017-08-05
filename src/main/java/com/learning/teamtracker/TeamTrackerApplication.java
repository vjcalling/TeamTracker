package com.learning.teamtracker;

import org.glassfish.jersey.server.ResourceConfig;

public class TeamTrackerApplication extends ResourceConfig {
	public TeamTrackerApplication() {
		
		register(new TeamTrackerBinder());
		packages(true, "com.learning.teamtracker");
	}

}
