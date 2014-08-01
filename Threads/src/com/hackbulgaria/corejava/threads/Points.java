package com.hackbulgaria.corejava.threads;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Points {

	public static int NUMBER_POINTS = 0;
	private static final int MAX_COORDINATE = 10_000;
	private static final double MAX_DISTANCE = Math.sqrt(2) * MAX_COORDINATE;

	public static List<Point> generatePoints(int numberPoints) {

		List<Point> allPoints = new ArrayList<Point>();
		Point point;
		Random randomGenerator = new Random();

		for (int i = 0; i < numberPoints; i++) {
			point = new Point(randomGenerator.nextInt(MAX_COORDINATE),
					randomGenerator.nextInt(MAX_COORDINATE));
			allPoints.add(point);
		}
		return allPoints;
	}

	public static Map<Point, Point> getNearestPoints(
			final List<Point> generatedPoints) throws InterruptedException {

		final Map<Point, Point> distances = Collections
				.synchronizedMap(new HashMap<Point, Point>());

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				doCalculations(generatedPoints, 0, NUMBER_POINTS / 2, distances);
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				doCalculations(generatedPoints, NUMBER_POINTS / 2 + 1,
						NUMBER_POINTS, distances);
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();

		return distances;
	}

	// Must be implemented with thread pool
	public static Map<Point, Point> getNearestPointsMaxCores(
			final List<Point> generatedPoints) throws InterruptedException {
		final List<Integer> threadsInfo = optimizeThreads(generatedPoints);
		final Map<Point, Point> distances = Collections
				.synchronizedMap(new HashMap<Point, Point>());
		// List<Thread> threads = new ArrayList<Thread>();
		int cores = threadsInfo.get(0);
		Thread[] threads = new Thread[cores];

		for (int i = 1; i < cores; i++) {
			final int index = i;
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {

					doCalculations(generatedPoints, threadsInfo.get(index),
							threadsInfo.get(index + 1), distances);
				}
			});
		}
		
		for (int i = 1; i < cores; i++) {
			threads[i].start();
		}
		for (int i = 1; i < cores; i++) {
			threads[i].join();
		}
		
		return distances;
	}

	public static void doCalculations(List<Point> inPoints, int indexFrom,
			int indexTo, Map<Point, Point> outMap) {

		double currentDistance = 0;
		double shortestDistance = MAX_DISTANCE;
		Point nearestPoint = new Point();

		for (int i = indexFrom; i < indexTo; i++) {
			double startX = inPoints.get(i).getX();
			double startY = inPoints.get(i).getY();

			for (int j = 0; j < inPoints.size(); j++) {
				double nextX = inPoints.get(j).getX();
				double nextY = inPoints.get(j).getY();

				if (inPoints.get(i) != inPoints.get(j)) {
					currentDistance = Point.distance(startX, startY, nextX,
							nextY);
					if (currentDistance < shortestDistance) {
						nearestPoint = inPoints.get(j);
					}
				}
			}
			outMap.put(inPoints.get(i), nearestPoint);
		}
	}


	public static List<Integer> optimizeThreads(List<Point> points) {
		List<Integer> threadingParameters = new ArrayList<Integer>();
		int cores = Runtime.getRuntime().availableProcessors();
		int startingPointsInterval = points.size() / cores;
		int index = 0;

		threadingParameters.add(cores);
		for (int i = 0; i < cores; i++) {
			threadingParameters.add(index);
			index += startingPointsInterval;
		}

		return threadingParameters;
	}

}
