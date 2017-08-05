package com.learning.teamtracker;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import com.learning.teamtracker.dao.EngineerDao;

public class TeamTrackerBinder extends AbstractBinder {
    
	final EngineerDao engineerDao = new EngineerDao();
	
	@Override
    protected void configure() {
        bind(engineerDao).to(EngineerDao.class);
    }
}
