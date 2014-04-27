package com.johnpickup;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TrainingCalendarExport {

	private static DateTimeFormatter ddmmyyyy = DateTimeFormat.forPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		try {
			String inputFilename = args[0];
			String outputFilename = args[1];
			LocalDate raceDate = LocalDate.parse(args[2], ddmmyyyy);
			ProgrammeReader reader = new ProgrammeReader(inputFilename);
			Programme programme = reader.read();
			Schedule schedule = ScheduleGenerator.generate(programme, raceDate);
			System.out.println(schedule.toString());
			
			ScheduleWriter writer;
			if (outputFilename.endsWith(".xls")) {			
				writer = new ScheduleExcelWriter(outputFilename);
			}
			else if (outputFilename.endsWith(".ics")) {			
				writer = new ScheduleIcalWriter(outputFilename);
			}
			else {
				throw new RuntimeException("Unsupported file type " + outputFilename);
			}
			
			writer.write(schedule);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
