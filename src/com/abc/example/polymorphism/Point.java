package com.abc.example.polymorphism;

//Point.java: the class Point
public class Point extends Shape {
	protected int x, y;

	// constructor
	public Point(int a, int b) {
		x = a;
		y = b;
	}

	// get x coordinate
	public int getX() {
		return x;
	}

	// get y coordinate
	public int getY() {
		return y;
	}

	// convert the point into a String representation
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	// return the class name
	public String getName() {
		return "Point";
	}
}