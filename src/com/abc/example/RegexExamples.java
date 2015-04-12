package com.abc.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {
	
	public static void verify_yahoo(){
		Pattern pattern = Pattern.compile("^https?://\\w+\\.com$");
		Matcher matcher1 = pattern.matcher("https://yahoo1.com");
		Matcher matcher2 = pattern.matcher("http://yahoo.com");
		
		System.out.println("matcher: " + matcher1.matches());
		System.out.println("matcher: " + matcher2.matches());
	}
	
	public static void verify_url(){
		String [] url_list = {
				"http://sub-1.dom.com/p1?k1=v1&k2=v2#f1",
	            "https://subc.dom.com/p2",
	            "http://subd.dom.com/p3",
	            "http://sub-1.dom1.com/p1?k1=v1&k2=v2#f1",
	            "dom/com",
				"blah dom.com",
	            "http://a dom com1"
		};
		
		String regex = "^https?://sub-?\\w+.dom1?.com/p[123](([?=&#]\\w{2}){5})?$";
		
		for (int i=0; i<url_list.length; i++){
			String url = url_list[i];
			if (url.matches(regex)) {
				System.out.println("Found good url: " + url);
			}
		}
	}
	
	// Matching/Validating
	public static void verify_ssn() {
		List<String> input = new ArrayList<String>();
		input.add("123-45-6789");
		input.add("9876-5-4321");
		input.add("987-65-4321 (attack)");
		input.add("987-65-4321 ");
		input.add("192-83-7465");

		for (String ssn : input) {
			if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
				System.out.println("Found good SSN: " + ssn);
			}
		}
		/*
		"^(\\d{3}-?\\d{2}-?\\d{4})$"
		
		 ^		match the beginning of the line
		() 		group everything within the parenthesis as group 1
		\d{n}	match n digits, where n is a number equal to or greater than zero
		-?		optionally match a dash
		$		match the end of the line
		 */
	}
	
	// Extracting/Capturing
	// matcher.find()
	// matcher.group()
	public static void extract() {
		String input = "I have a cat, but I like my dog better.";

		Pattern pattern = Pattern.compile("(mouse|cat|dog|wolf|bear|human)");
		Matcher matcher = pattern.matcher(input);

		List<String> animals = new ArrayList<String>();
		while (matcher.find()) {
			System.out.println("Found a " + matcher.group() + ".");
			animals.add(matcher.group());
		}
		/*
		("(mouse|cat|dog|wolf|bear|human)"
		
		 ()		group everything within the parenthesis as group 1
		mouse		match the text ‘mouse’
		|		alternation: match any one of the sections of this group
		cat		match the text ‘cat’
 
		//...and so on
		 */
	}
	
	// using Matcher.replaceFirst() and replaceAll() methods
	public static void replaceFirst(){
		
		Pattern pattern = Pattern.compile("1*2");
		Matcher matcher = pattern.matcher("11234512678");
		
		String replace_all = matcher.replaceAll("_");
		String replace_first = matcher.replaceFirst("_");
		
		System.out.println("Using replaceAll: " + replace_all);
		System.out.println("Using replaceFirst: " + replace_first);
	}
	
	// Modifying/Substitution
	// matcher.find()
	// matcher.group(n)
	// matcher.appendReplacemen()
	// matcher.appendTail(result)
	public static void replace() {
		String input = "User clientId=23421. Some more text clientId=33432. This clientNum=100";

		Pattern pattern = Pattern.compile("(clientId=)(\\d+)");
		Matcher matcher= pattern.matcher(input);

		StringBuffer result = new StringBuffer();
		while (matcher.find()) {
			System.out.println("Masking: " + matcher.group(2));
			matcher.appendReplacement(result, matcher.group(1) + "***masked***");
		}
		matcher.appendTail(result);
		System.out.println(result);
		/*
		 "(clientId=)(\\d+)"
		 
		(clientId=) 	group everything within the parenthesis as group 1
		clientId=	match the text ‘clientId=’
		(\\d+)		group everything within the parenthesis as group 2
		\\d+		match one or more digits
		 */
	}

	public static void split(){
		Pattern pattern = Pattern.compile("\\W");
		
		String[] words = pattern.split("one@two#three:four$five");
		for (String s : words) {
			System.out.println("Split using Pattern.split(): " + s);
		}
	}
	/*
	 * matcher.find()
	 * matcher.start()
	 * matcher.replaceAll(String str)
	 * matcher.replaceFirst(String str)
	 */
	public static void use_matcher_method(){
		// using pattern with flags
		Pattern pattern = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("ABcabdAb");
		
		// using Matcher find(), group(), start() and end() methods
		while (matcher.find()) {
			System.out.println("Found the text \'" + matcher.group()
					+ "\' starting at " + matcher.start()
					+ " index and ending at index " + matcher.end());
		}
	}
	
	public static void FindLongestSubString(String str) {
		Set<String> subStr = new HashSet<String>();
		Map<Integer, String> hashMap = new HashMap<Integer, String>();

		int position = 0;
		int len = 0;
		int size = str.length();
		for (int i = 0; i < size; i++) {
			if (!subStr.add(String.valueOf(str.charAt(i)))) {
				String tmp = str.substring(position, i);
				System.out.print(tmp+"\n");
				len = i - position;
				position = i;
				hashMap.put(len, tmp);
				
				i = i - 1;
				subStr = new HashSet<String>();
			}
		}
		String tmp = str.substring(position, size);
		System.out.print(tmp+"\n");
		len = size - position;
		hashMap.put(len, tmp);
		System.out.print("\n");
		
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();

			System.out.println(key + " => " + value);
		}
	}
	
	public static void verify_cancel() {
		System.out.println("\n");
		
		String[] expected_data = {"cancel", "cancel button"};
		
		String regex="(D/IVONATextToSpeechService)\\(\\s\\d+\\):\\s(onSynthesizeText:)\\s(";
		for (int i=0; i<expected_data.length; i++){
			regex+= "(" + expected_data[i] + ")";
			if (i !=expected_data.length-1)
				regex+="|";
			else
				regex+=")$";
		}
		
		//regex = "(D/IVONATextToSpeechService)\\(\\s\\d+\\):\\s(onSynthesizeText:)\\s((cancel)|(cancel button)|(cancel cancel))$";
		System.out.println("regex: " + regex);
		
		List<String> logcat_data = new ArrayList<String>();
		logcat_data.add("D/IVONATextToSpeechService( 1648): onSynthesizeText: cancel");
		logcat_data.add("D/IVONATextToSpeechService( 1648): onSynthesizeText: cancel button");
		logcat_data.add("D/IVONATextToSpeechService( 1648): onSynthesizeText: cancel button cancel");
		logcat_data.add("D/IVONATextToSpeechService( 1648): onSynthesizeText: cancel cancel");
		
		logcat_data.add("D/IVONATextToSpeechService( 1648): : cancel");
		logcat_data.add("D/IVONATextToSpeechService( 1648): onSynthesizeText cancel button");
		logcat_data.add("D/IVONATextToSpeechService( 1648): onSynthesizeext: cancel button cancel");
		logcat_data.add("D/IVONATextToSpeechService( 1648): onSyntheizeText: cancel cancel");
		
		Pattern pattern = Pattern.compile(regex);
		for (String data : logcat_data) {
			Matcher matcher = pattern.matcher(data);
			while (matcher.find()) {
				System.out.println(data);
				//System.out.println("matcher.group( ): " + matcher.group());
				//System.out.println("matcher.group(1): " + matcher.group(1));
				//System.out.println("matcher.group(2): " + matcher.group(2));
				System.out.print("Found matcher: " + matcher.group(3));
				System.out.print("\n");
			}
		}
		
		//String data2 = "D/LoganCore( 4850): setAccessibilityFocusInternal package=com.android.systemui class=android.widget.ImageView bounds=Rect(59, 863 - 129, 932) label=|Apps|";
		//String regex2="(D/LoganCore)\\(\\s\\d+\\):\\s(setAccessibilityFocusInternal)(\\s\\w+=\\.+){2}bounds=Rect\\(\\d+,\\s\\d+\\s-\\s\\d+,\\sd+\\)\\slabel=\\|(Apps)\\|";
		
		//String data2 = "D/LoganCore( 4850): setAccessibilityFocusInternal package=com.android.systemui class=android.widget.ImageView ";
		//String regex2="(D/LoganCore)\\(\\s\\d+\\):\\s(setAccessibilityFocusInternal)(\\s(\\w+=)(.*)){2}";
		
		String data2 = "D/LoganCore( 4850): setAccessibilityFocusInternal package=com.android.systemui class=android.widget.ImageView bounds=Rect(59, 863 - 129, 932) label=|Apps|";
		String regex2="(D/LoganCore)\\(\\s\\d+\\):\\s(setAccessibilityFocusInternal)(\\s\\.*label=|)(Apps|)";
		
		
		System.out.print(regex2);
		
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(data2);
		while (matcher2.find()) {
			System.out.print("\n");
			System.out.println(data2);
			System.out.print("group(1): " + matcher2.group(1));
			System.out.print("\ngroup(2): " + matcher2.group(2));
			System.out.print("\ngroup(3): " + matcher2.group(3));
			System.out.print("\ngroup(4): " + matcher2.group(4));
			System.out.print("\n");
		}
		
		if(data2.indexOf("setAccessibilityFocusInternal")!=-1 
				&& data2.indexOf("label=|")!=-1
				&& data2.indexOf("Apps")!=-1){
			System.out.print("found");
		}
	}
		
	public static void main(String[] args) {
		verify_yahoo();			System.out.print("\n");
		verify_url();			System.out.print("\n");
		verify_ssn();			System.out.print("\n");
		extract();				System.out.print("\n");
		replaceFirst();			System.out.print("\n");
		replace();				System.out.print("\n");
		split();				System.out.print("\n");
		use_matcher_method();	System.out.print("\n");
		
		System.out.print(Pattern.matches("(\\w\\d)\\1", "a2a2"));  // true
		System.out.print(Pattern.matches("(\\w\\d)\\1", "a2b2"));  // false
		System.out.print(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B2AB"));  // true
		System.out.print(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B3AB"));  // true
		verify_cancel();
	}

}
/*
matcher: true
matcher: true

Found good url: http://sub-1.dom.com/p1?k1=v1&k2=v2#f1
Found good url: https://subc.dom.com/p2
Found good url: http://subd.dom.com/p3
Found good url: http://sub-1.dom1.com/p1?k1=v1&k2=v2#f1

Found good SSN: 123-45-6789
Found good SSN: 192-83-7465

Found a cat.
Found a dog.

Using replaceAll: _345_678
Using replaceFirst: _34512678

Masking: 23421
Masking: 33432
User clientId=***masked***. Some more text clientId=***masked***. This clientNum=100

Split using Pattern.split(): one
Split using Pattern.split(): two
Split using Pattern.split(): three
Split using Pattern.split(): four
Split using Pattern.split(): five

Found the text 'AB' starting at 0 index and ending at index 2
Found the text 'ab' starting at 3 index and ending at index 5
Found the text 'Ab' starting at 6 index and ending at index 8
*/