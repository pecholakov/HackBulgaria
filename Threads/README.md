Nearest Points
=======

Introduction
-------
The program generates a certain number of random points in two-dimensional space. For every point it finds its nearest point in distance.
It compares the time needed for calculation on different amount of threads. NearestPoints uses three approaches for solving the task, based on the used threads:
	- sequental;
	- two threads; 
	- most cores available.

Usage
-------
To run the program write in the console line:

    java -jar nearestPoints.jar <number of points>
  

