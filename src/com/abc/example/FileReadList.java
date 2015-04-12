package com.abc.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReadList {
	private static String file = "/home/jtong/workspace_jenny/zzzExample/src/com/amazon/qa/list.txt";
	
	public static void readList1() throws IOException{
		
        FileReader fr = null;
        BufferedReader in = null;
        
        List<Double> list = new ArrayList<Double>();
        try {
            fr = new FileReader(file);
            in = new BufferedReader(fr);
            
            String line;
            while ((line = in.readLine()) != null) {
                list.add(Double.parseDouble(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
            fr.close();
        }

        for (double d : list) 
        	System.out.println(d);
	}
	
	public static void readList2() throws FileNotFoundException{
		// or another approach
	    Scanner scanner = new Scanner(new File(file));
	    List<Double> doubles = new ArrayList<Double>();
	    
	    while(scanner.hasNextDouble()){
	        doubles.add(scanner.nextDouble());
	    }
	    Collections.sort(doubles);
		for (Double d : doubles)
			System.out.print(d + "\n");
	}

    public static void main(String[] args) throws IOException {
    	readList1();
    	System.out.print("\n");
    	readList2();
    }
}
