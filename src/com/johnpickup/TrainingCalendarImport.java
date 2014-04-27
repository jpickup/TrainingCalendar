package com.johnpickup;

public class TrainingCalendarImport {

	public static void main(String[] args) {
		String inputFilename = args[0];
		String outputFilename = args[1];
		ScheduleReader scheduleReader = new ScheduleReader();
		try {
			Schedule schedule = scheduleReader.read(inputFilename);
			System.out.println(schedule.toString());
			Programme programme = ScheduleConverter.convertToProgramme(schedule);
			
			ProgrammeWriter writer = new ProgrammeWriter(outputFilename);
			writer.write(programme);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
