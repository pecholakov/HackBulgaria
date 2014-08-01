package com.hackbulgaria.corejava.threads;

import java.awt.Point;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		//Points.NUMBER_POINTS = parseInt(args[0]);
		//int number = parseInt(args[0]);
		Points.NUMBER_POINTS = Integer.parseInt(args[0]);
		List<Point> allPoints = Points.generatePoints(Points.NUMBER_POINTS);
		Map<Point, Point> closestPoints = Collections
				.synchronizedMap(new HashMap<Point, Point>());

		long start_time = System.currentTimeMillis();
		Points.doCalculations(allPoints, 0, Points.NUMBER_POINTS, closestPoints);
		long end_time = System.currentTimeMillis();
		double time = ((end_time - start_time) / 1000.0);	
		System.out.println("Executed sequential for: " + time + "s");

		long start_time2 = System.currentTimeMillis();
		Points.getNearestPoints(allPoints);
		long end_time2 = System.currentTimeMillis();
		double time2 = ((end_time2 - start_time2) / 1000.0);
		System.out.println("Executed on two threads for: " + time2 + "s");

		long start_time3 = System.currentTimeMillis();
		Points.getNearestPointsMaxCores(allPoints);
		long end_time3 = System.currentTimeMillis();
		double time3 = ((end_time3 - start_time3) / 1000.0);
		System.out.println("Executed on max available cores("
				+ Points.optimizeThreads(allPoints).get(0) + ") for: " + time3 + "s");
	}

}
