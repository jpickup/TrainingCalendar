package com.johnpickup;

import org.joda.time.LocalDate;

public class ScheduledWorkout {
	private final String name;
	private final String description;
	private final LocalDate date;
	public ScheduledWorkout(String name, String description, LocalDate date) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getDate() {
		return date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduledWorkout other = (ScheduledWorkout) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ScheduledWorkout [name=" + name + ", description="
				+ description + ", date=" + date + "]";
	} 
	
}
