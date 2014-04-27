package com.johnpickup;

import org.joda.time.LocalDate;

import net.fortuna.ical4j.model.component.VEvent;

public class IcalEventConverter {

	private static final String RUNNING = " (Running)";

	public static ScheduledWorkout convert(VEvent event) {
		String name = event.getSummary().getValue();
		 
		if (name.contains(RUNNING)) {
			name = name.substring(0, name.indexOf(RUNNING)+1);
		}
		
		String description = event.getDescription().getValue();
		LocalDate date = LocalDate.fromDateFields(event.getStartDate().getDate());
		
		ScheduledWorkout result = new ScheduledWorkout(name, description, date);
		return result;
	}

}
