package com.abc.example.polymorphism;

/* 

OOD:
1. abstraction
2. encapsulation
3. inheritance
4. polymorphism

What is Polymorphism
1. Polymorphism is the ability to create a variable, a function, or an object that has more than one form.

2. In java, polymorphism is divided into two parts : method overloading and method overriding.
1) Compile time polymorphism (static binding or method overloading)
2) Runtime polymorphism (dynamic binding or method overriding)

3. Operator overloading is form of polymorphism, e.g. “+” operator can be used to add two integers as well as concat two sub-strings.
Well, this is the only available support for operator overloading in java, and you can not have your own custom defined operator overloading in java.

*/


//ShapeTest.java: test point, circle, cylinder hierarchy
public class ShapeTest {

	private Shape shapes[];

	public void createShapes() {

		shapes = new Shape[15]; // generic array of any shape

		shapes[0] = new Rectangle(3.0, 4.0, 6, 8);
		shapes[1] = new Point(7, 11);
		shapes[2] = new Circle(3.5, 22, 8);
		shapes[3] = new Cylinder(10, 3.3, 10, 10);
		shapes[4] = new RectangularSolid(2.0, 3.0, 4.0, 6, 8);
		shapes[5] = new Point(8, 12);
		shapes[6] = new Rectangle(2.0, 2.0, 7, 9);
		shapes[7] = new Circle(3.6, 23, 9);
		shapes[8] = new Cylinder(12, 3.4, 20, 20);
		shapes[9] = new Rectangle(6.0, 6.0, 5, 7);
		shapes[10] = new RectangularSolid(3.0, 3.0, 3.0, 10, 4);
		shapes[11] = new Point(9, 13);
		shapes[12] = new Circle(3.7, 24, 10);
		shapes[13] = new Cylinder(14, 3.5, 30, 30);
		shapes[14] = new RectangularSolid(4.0, 4.0, 4.0, 8, 9);
	}

	public void printShapes() {

		// Loop through arrayOfShapes. Use polymorphism to print the name,
		// area, and volume of each object.
		System.out.println("PRINT THE SHAPES AS AN ARRAY OF SHAPE");
		for (int i = 0; i < shapes.length; i++) {
			System.out
					.println(shapes[i].getName() + ": " + shapes[i].toString()
							+ ", ID: " + shapes[i].getIdNumber());
			System.out.println("Area = " + shapes[i].area());
			System.out.println("Volume = " + shapes[i].volume());
			System.out.println();
		}
	}

	// insertionSort: Sorts array of Shapes using the insertion sort
	public void insertionSort() {
		for (int index = 1; index < shapes.length; index++) {
			Shape key = shapes[index];
			int position = index;
			// shift larger values to the right
			while (position > 0 && compareShapes(shapes[position - 1], key) > 0) {
				shapes[position] = shapes[position - 1];
				position--;
			}
			shapes[position] = key;
		}
	}

	private int compareShapes(Shape s1, Shape s2) {
		if ((s1.getName()).equals(s2.getName()))
			return s1.getIdNumber() - s2.getIdNumber();
		else
			return (s1.getName()).compareTo(s2.getName());
	}

	public static void main(String[] args) {
		ShapeTest shapeTest = new ShapeTest();
		shapeTest.createShapes();
		shapeTest.insertionSort();
		shapeTest.printShapes();
	}
}
