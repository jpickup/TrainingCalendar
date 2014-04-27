package com.johnpickup;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class ScheduleConverter {

	public static Programme convertToProgramme(Schedule schedule) {
		Programme result = new Programme();
		
		LocalDate raceDate = schedule.getRaceDate();
		
		for (ScheduledWorkout workout : schedule.getWorkouts()) {
			String name = workout.getName();
			String description = workout.getDescription();
			Days days = Days.daysBetween(workout.getDate(), raceDate);
			int offset = -days.getDays();
			PlannedWorkout plannedWorkout = new PlannedWorkout(name, description, offset);
			result.addWorkout(plannedWorkout);
		}		

		return result;
	}

}
