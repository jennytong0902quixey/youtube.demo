package com.abc.example.generic;

/*
the type parameter section of a generic class can have one or more type parameters separated by commas. 
These classes are known as parameterized classes or parameterized types because they accept one or more parameters.

What is the benefit of using Java generics?
Early error detection at compile time. 

 Example (using a parameterized type): 

    LinkedList<String> list = new LinkedList<String>();
    list.add("abc");       // fine
    list.add(new Date());  // error 
 */

public class Box<T> {
	  private T t;

	  public void add(T t) {
	    this.t = t;
	  }

	  public T get() {
	    return t;
	  }

	  public static void main(String[] args) {
	     Box<Integer> integerBox = new Box<Integer>();
	     Box<String> stringBox = new Box<String>();
	    
	     integerBox.add(new Integer(10));
	     stringBox.add(new String("Hello World"));

	     System.out.printf("Integer Value :%d\n\n", integerBox.get());
	     System.out.printf("String Value :%s\n", stringBox.get());
	  }
	}
