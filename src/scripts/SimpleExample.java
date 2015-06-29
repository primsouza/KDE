package scripts;

import java.util.List;

import utils.Helpers;
import model.Event;
import model.KDE;
import dataManager.SimpleDataParser;

/**
 * This is a simple script that shows an example of loading simple 2-dim data
 * and converting it to an Event data type.
 * 
 * Then, to complete the example we show use of both Fixed-KDE and Adaptive-KDE
 * on that data by estimating the integration on the entire space.
 * 
 * In this example we will not use the ID property of the event and we will
 * assume that all data comes from the same individual. 
 * 
 * For more details on the two approaches see: http://www.datalab.uci.edu/papers/kernel_KDD2014.pdf
 * 
 * @author Lichman
 *
 */
public class SimpleExample
{
	private static final String FILE_PATH = "./prop/simple_data";
	
	public static void main(String ... args ) throws Exception
	{
		List<Event> trainData = SimpleDataParser.loadData(FILE_PATH);
		
		// Creating the test data - because in this simple example we compute the integration
		// over the "entire" space, we create the test data as grid box.
		double[] xs = Helpers.makeSequence(-10, 10, 1000);
		double[] ys = Helpers.makeSequence(-10, 10, 1000);
		
		double area = (xs[1] - xs[0]) * (ys[1] - ys[0]);
		
		// First we train the fixed-KDE model with BW=2
		KDE fixed = KDE.trainFixedKDE(trainData, 2);
		
		double intSum = 0;
		for(double x : xs)
		{
			for(double y : ys)
			{
				double[] p = {x,y};
				Event etest = new Event(0,p);
				intSum += Math.exp(fixed.logPdf(etest)) * area;
			}
		}
		
		System.out.println(intSum);
		
		// Now - doing the same thing with Adaptive-KDE
		KDE adaptive = KDE.trainAdaptiveKDE(trainData, 2);
		
		intSum = 0;
		for(double x : xs)
		{
			for(double y : ys)
			{
				double[] p = {x,y};
				Event etest = new Event(0,p);
				intSum += Math.exp(adaptive.logPdf(etest)) * area;
			}
		}
		
		System.out.println(intSum);
	}
}
