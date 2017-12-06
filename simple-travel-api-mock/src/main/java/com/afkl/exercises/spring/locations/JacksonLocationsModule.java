package com.afkl.exercises.spring.locations;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class JacksonLocationsModule extends SimpleModule {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5434717927487764994L;

	@Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Location.class, LocationMixin.class);
        context.setMixInAnnotations(Coordinates.class, CoordinatesMixin.class);
    }

}
