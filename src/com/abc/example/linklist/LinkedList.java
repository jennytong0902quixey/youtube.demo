package com.abc.example.linklist;

import java.util.List;

public class LinkedList {
    private class Node {
    	private Object data;
    	private Node next;
 
        public Node(Object data) {
            this.data = data;
            next = null;
        }
 
        public Node(Object data, Node next) {
            this.next = next;
            this.data = data;
        }
 
        public Object getData() {
            return data;
        }
 
        public void setData(Object data) {
            this.data = data;
        }
 
        public Node getNext() {
            return next;
        }
 
        public void setNext(Node next) {
            this.next = next;
        }
    }
    
    private Node head;
    private int size;
 
    public LinkedList() {
        head = new Node(null);
        size = 0;
    }
 
    public void add(Object data){
        Node temp = new Node(data);
        Node current = head;
        
        while (current.getNext() != null) {
        	current = current.getNext();
        }
        current.setNext(temp);
        size++;
    }
 
    public void add(Object data, int index){
        Node temp = new Node(data);
        Node current = head;
        
        // crawl to the requested index or the last element in the list, whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
        	current = current.getNext();
        }
        
        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
    }
 
    public boolean remove(int index){
        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;
 
        Node current = head;
        for (int i = 1; i < index; i++) {
        	current = current.getNext();
            if (current == null)
                return false;
        }
        current.setNext(current.getNext().getNext());
        size--; 
        return true;
    }
    
    public Object get(int index){
    	if (index < 1 || index > size())
            return null;
 
        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
        	 current = current.getNext();
        	 if (current == null)
                 return null;
        }
        return current.getData();
    }
 
    public boolean removeFromList(String data){
    	if (size <= 0)
    		return false;
    	
    	Node current = head;
    	
    	for (int i=0; i<size && current.getNext()!=null; i++){
    		String str = (String) current.getNext().getData();
    		if (data.equalsIgnoreCase(str)){
    			current.setNext(current.getNext().getNext());
    			return true;
    		}
    		current = current.getNext();
    	}
    	return false;
    }
    public int size(){
        return size;
    }
 
    public String toString() {
        Node current = head.getNext();
        String output = "";
        while (current != null) {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return output;
    }
// 
//    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
// 
//        // add elements to LinkedList
//        linkedList.add("1");
//        linkedList.add("2");
//        linkedList.add("3");
//        linkedList.add("4");
//        linkedList.add("5");
// 
//        /*
//         * Please note that primitive values can not be added into LinkedList
//         * directly. They must be converted to their corresponding wrapper
//         * class.
//         */
// 
//        System.out.println("linkedList - print linkedlist: " + linkedList);
//        System.out.println("linkedList.size() - print linkedlist size: " + linkedList.size());
//        System.out.println("linkedList.get(3) - get 3rd element: " + linkedList.get(3));
//        System.out.println("linkedList.remove(2) - remove 2nd element: " + linkedList.remove(2));
//        System.out.println("linkedList.get(3) - get 3rd element: " + linkedList.get(3));
//        System.out.println("linkedList.size() - print linkedlist size: " + linkedList.size());
//        System.out.println("linkedList - print linkedlist: " + linkedList);
//        
//        System.out.println("linkedList.removeFromList - : " + linkedList.removeFromList("4"));
//        System.out.println("linkedList - print linkedlist: " + linkedList);
//        System.out.println("linkedList.removeFromList - : " + linkedList.removeFromList("1"));
//        System.out.println("linkedList - print linkedlist: " + linkedList);
//        System.out.println("linkedList.removeFromList - : " + linkedList.removeFromList("5"));
//        System.out.println("linkedList - print linkedlist: " + linkedList);
//        System.out.println("linkedList.removeFromList - : " + linkedList.removeFromList("3"));
//        System.out.println("linkedList - print linkedlist: " + linkedList);
//    }
    
    public static void main(String args[]) {
        //creating LinkedList with 5 elements including head
      LinkedList linkedList = new LinkedList();
      LinkedList.Node head = linkedList.head;
      linkedList.add( "1");
      linkedList.add( "2");
      linkedList.add( "3");
      linkedList.add( "4");
      //linkedList.add( "5");
      
      int size = linkedList.size();
      int middle = (size / 2);
      
      String mvalue = linkedList.get(middle).toString();
      

      System.out.println("length of LinkedList: " + size);
      System.out.println("middle element of LinkedList : " + mvalue);
     
    }
	
}
