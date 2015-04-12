package com.abc.example.linklist;

import java.util.NoSuchElementException;

public class Stack {
    private Object[] array;
    private int size = 0;

    public Stack(int capacity) {
        array = new Object[capacity];
    }

    public void push(Object item) {
        if (size == array.length) {
            throw new IllegalStateException("Cannot add to full stack");
        }
        array[size++] = item;
    }

    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot pop from empty stack");
        }
        Object result = array[size-1];
        array[--size] = null;
        return result;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty stack");
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

	public static void main(String[] args) {
		Stack theStack = new Stack(10);
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);
		while (!theStack.isEmpty()) {
			int value = (Integer) theStack.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
