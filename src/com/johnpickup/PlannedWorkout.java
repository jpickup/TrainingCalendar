package com.johnpickup;

public class PlannedWorkout {
	private final String name;
	private final String description;
	private final int offset;
	public PlannedWorkout(String name, String description, int offset) {
		super();
		this.name = name;
		this.description = description;
		this.offset = offset;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getOffset() {
		return offset;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + offset;
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
		PlannedWorkout other = (PlannedWorkout) obj;
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
		if (offset != other.offset)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PlannedWorkout [name=" + name + ", description=" + description
				+ ", offset=" + offset + "]";
	}

}
