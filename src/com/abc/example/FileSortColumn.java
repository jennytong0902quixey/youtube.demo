package com.abc.example;

import java.io.*;
import java.util.*;

/*
Monday
Jessica  Run      20mins
Alba     Walk     20mins
Amy      Jogging  40mins
Bobby    Run      10mins
Tuesday
Mess     Run      20mins
Alba     Walk     20mins
Christy  Jogging  40mins
Bobby    Run      10mins
 */
public class FileSortColumn {
	private static String inputFile = "/home/jtong/workspace_jenny/zzzExample/src/com/amazon/qa/data.txt";
	private static String outputFile = "/home/jtong/workspace_jenny/zzzExample/src/com/amazon/qa/data2.txt";
	
	public static void sortMultipleColumns() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		
		//tree map is sorted
		Map<String, String> map = new TreeMap<String, String>();
		String line = "";
		
		while ((line = reader.readLine()) != null) {
			map.put(line.split(" ")[0], line); // extract value you want to sort on
			System.out.print(line + "\n");
		}
		reader.close();
		System.out.print("\n");
		
		FileWriter writer = new FileWriter(outputFile);
		for (String val : map.values()) {
			writer.write(val);
			System.out.print(val + "\n");
			writer.write('\n');
		}
		writer.close();
	}

	public static String getField(String line) {
		return line.split(" ")[0];	// extract value you want to sort on
	}

	public static void sortSingleColumn() throws IOException{
		BufferedReader reader = null;
        PrintWriter outputStream = null;
        
        ArrayList<String> rows = new ArrayList<String>();
        try {
            reader  = new BufferedReader(new FileReader(inputFile));
            outputStream = new PrintWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
            	System.out.print(line + "\n");
                rows.add(line);
            }
            System.out.print("\n");
            
            Collections.sort(rows);
            String[] strArr= rows.toArray(new String[0]);
            for (String cur : strArr){
                outputStream.println(cur);
                System.out.print(cur + "\n");
            }
            
        } finally {
            if (reader  != null) {
            	reader.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
	}

	public static void main(String[] args) throws Exception {
		sortSingleColumn();
		System.out.print("\n");
		sortMultipleColumns();
	}

}
