package com.johnpickup;

import org.joda.time.LocalDate;

public class Scheduler {

	public ScheduledWorkout schedule(PlannedWorkout workout, LocalDate raceDate) {
		String name = workout.getName();
		String description = workout.getDescription();
		LocalDate date = raceDate.plusDays(workout.getOffset());
		ScheduledWorkout result = new ScheduledWorkout(name, description, date);
		
		return result;
	}

}
