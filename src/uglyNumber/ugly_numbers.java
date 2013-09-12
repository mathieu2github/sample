package uglyNumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class ugly_numbers {
		
	/*
	 * main method
	 */
	public static void main (String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
		ugly_numbers sol = new ugly_numbers();

	    while ((line = in.readLine()) != null) {
	        String[] lineArray = line.split("\\s");
	        if (lineArray.length > 0) {
	        	int count = 0;
		    	ArrayList<String> result = sol.getComb(line, 0);
		    	for (String s : result) {
		    		if (sol.isUgly(sol.calString(s)))
		    			count++;
		    	}
		    	System.out.println(count);
	        }
	    }
		
//		while ((line = in.readLine()) != null) {
//			String[] lineArray = line.split("\\s");
//			if (lineArray.length > 0) {
//				HashSet<String> count = new HashSet<String>();
//		    	ArrayList<String> result = sol.getComb(line, 0);
//		    	for (String s : result) {	
//		    		count.add(s);
//		    	}
//				System.out.println(count.size());
//			}
//		}
	}
	
	/*
	 * using recursive way to get all the 3^(d - 1) possible strings
	 * first call of getComb and always set index to 0
	 * when index == 0, adding first character from s to its sub results and its done
	 * when index != 0, appending the character at that index of s after "" or "+" or "-"
	 * and also adding them to its sub results
	 */	
	private ArrayList<String> getComb(String s, int index) {
		ArrayList<String> result = new ArrayList<String>();
		
		if (s.length() == 1) {
			result.add(s);
			return result;
		}
		
//		if (index == s.length() - 1) {
//			result.add(s.substring(s.length() - 1));
//			result.add("+" + s.substring(index));
//			result.add("-" + s.substring(index));
//			return result;
//		}
		
		if (index == s.length()) {
			result.add(s.substring(s.length()));
			return result;
		}
		ArrayList<String> sub = getComb(s, index + 1);
		String additional = s.substring(index, index + 1);
		
		if (index == 0) {
			for (String ele : sub) 
				result.add(additional + ele);			
			return result;
		}
		
		for (String ele : sub) {
			result.add(additional + ele);
			result.add("+" + additional + ele);
			result.add("-" + additional + ele);
		}		
		return result;
	}
	
	/*
	 * judge whether integer n is ugly number or not and return true or false
	 */
	private boolean isUgly(long l) {
		if (l % 2 == 0 || l % 3 == 0 || l % 5 == 0 || l % 7 == 0)
			return true;
		return false;
	}
	
	/*return the value of input string
	 *which is generated by insert plus or minus or none into the given string of decimal digits
	 */
	private long calString(String s) {
		
		int firstIndex = 0;
		int secondIndex = 0;
		boolean sign = true;
		long first = 0;
		long second = 0;
		
		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				secondIndex = i;
				if (sign)
					second = Long.parseLong(s.substring(firstIndex, secondIndex));
				else
					second = 0 - Long.parseLong(s.substring(firstIndex, secondIndex));	
				firstIndex = i + 1;
				if (s.charAt(i) == '+')	
					sign = true;
				if (s.charAt(i) == '-')	
					sign = false;
				first += second;
			}
		}	
		
		if (sign) 
			second = Long.parseLong(s.substring(firstIndex));
		else
			second = 0 - Long.parseLong(s.substring(firstIndex));		
		first += second;	
		return first;
	}
	
	
	
}
