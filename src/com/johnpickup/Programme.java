package com.johnpickup;

import java.util.ArrayList;
import java.util.Collection;

public class Programme {
	private final Collection<PlannedWorkout> workouts = new ArrayList<PlannedWorkout>();

	public Collection<PlannedWorkout> getWorkouts() {
		return workouts;
	}
	
	public void addWorkout(PlannedWorkout workout) {
		workouts.add(workout);
	}

}
