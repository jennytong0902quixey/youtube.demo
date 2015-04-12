package com.abc.example.sample;
import static org.junit.Assert.*;

import org.junit.Test;


public class AsteriskNumTest {
	public String asteriskNum = "16506444501";

	@Test
	public void test() {
		for (int i=0; i< asteriskNum.length(); i++){
	    	StringBuffer button = new StringBuffer("button");
			String number = button.append(asteriskNum.charAt(i)).toString();
			System.out.print(number + "\n");
	    }   
		fail("Not yet implemented");
	}

}
