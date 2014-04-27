package com.johnpickup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.LocalDate;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;

public class ScheduleIcalWriter implements ScheduleWriter {
	private Calendar calendar;
	private String outputFilename;
	private final TimeZone timezone;
	private final VTimeZone tz;

	public ScheduleIcalWriter(String outputFilename) {
		this.outputFilename = outputFilename;
		// Create a TimeZone
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		timezone = registry.getTimeZone("Europe/London");
		tz = timezone.getVTimeZone();
	}

	@Override
	public void write(Schedule schedule) throws Exception {
		calendar = new Calendar();
		calendar.getProperties().add(new ProdId("-//John pickup//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);
		
	    List<ScheduledWorkout> workouts = new ArrayList<ScheduledWorkout>(schedule.getWorkouts());
	    Collections.sort(workouts, new Comparator<ScheduledWorkout>() {
			@Override
			public int compare(ScheduledWorkout arg0, ScheduledWorkout arg1) {
				return arg0.getDate().compareTo(arg1.getDate());
			}
	    });
	    
	    for (ScheduledWorkout workout : workouts) {
	    	writeWorkout(workout);
	    }
	    
	    FileOutputStream fos = new FileOutputStream(outputFilename);
	    
	    CalendarOutputter outputter = new CalendarOutputter();
	    outputter.output(calendar, fos);
	    fos.close();		
	}

	private void writeWorkout(ScheduledWorkout workout) throws IOException {
		LocalDate workoutDate = workout.getDate();
		java.util.Calendar date = new GregorianCalendar();
		date.setTimeZone(timezone);
		date.set(workoutDate.getYear(), workoutDate.getMonthOfYear()-1, workoutDate.getDayOfMonth());
		
		VEvent event = new VEvent(new Date(date.getTime()), workout.getName());
		Description description = new Description(workout.getDescription());
		event.getProperties().add(description);
		event.getProperties().add(tz.getTimeZoneId());
		
		UidGenerator ug = new UidGenerator(workout.getName());
		event.getProperties().add(ug.generateUid());
		
		calendar.getComponents().add(event);
	}

}
