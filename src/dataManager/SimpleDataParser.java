package dataManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.Event;

/**
 * A simple data parser that can be used to convert from text file to a list of events. This parser assumes that the data file is organized in three columns:
 * 
 * 1. Individual ID 2. X value 3. Y value
 * 
 * @author Lichman
 *
 */
public class SimpleDataParser
{
	public static List<Event> loadData(String filePath)
	{
		List<Event> events = new ArrayList<Event>();
		try
		{
			BufferedReader r = new BufferedReader(new FileReader(filePath));
		

		String line = "";
		while ((line = r.readLine()) != null)
		{
			line = line.trim();
			if (line.startsWith("#")) continue; // Comment line

			String[] parts = line.split("\\s+");
			long id = Long.parseLong(parts[0]);
			double xVal = Double.parseDouble(parts[1]);
			double yVal = Double.parseDouble(parts[2]);

			events.add(new Event(id, xVal, yVal));
		}

		r.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		return events;
	}
}
