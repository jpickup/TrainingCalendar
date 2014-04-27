package com.johnpickup;

import java.io.FileInputStream;
import java.util.Iterator;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VEvent;

public class ScheduleReader {
	public Schedule read(String inputFilename) throws Exception {
		Schedule schedule = new Schedule();
		
        FileInputStream fin = new FileInputStream(inputFilename);
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = builder.build(fin);
        
        for (@SuppressWarnings("unchecked")
		Iterator<Component> i = calendar.getComponents().iterator(); i.hasNext();) {
            Component component = i.next();
            if (component.getName().equals("VEVENT")) {
            	schedule.add(IcalEventConverter.convert((VEvent)component));
            }
        }
		
		return schedule;
	}
}
