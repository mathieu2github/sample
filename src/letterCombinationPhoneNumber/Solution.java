package letterCombinationPhoneNumber;

import java.util.ArrayList;

public class Solution {
	
    public ArrayList<String> letterCombinations(String digits) {
	// Start typing your Java solution below
	// DO NOT write main() function
	    ArrayList<String> result = new ArrayList<String>();
	    
        if (digits.length() == 0|| digits == " ") {// never use digits == "" this cause a lot of problems or runtime errors.
            result.add("");
            return result;
        }
        
		if (digits.length() == 1) {
			int n = Integer.parseInt(digits);
	        return lettersOnNum(n);
	    }
	            
	        
	    String sub = digits.substring(0, digits.length() - 1);
	    String last = digits.substring(digits.length() - 1);
//		String first = digits.substring(0,1);
//		String sup = digits.substring(1);
	    ArrayList<String> subresult = letterCombinations(sub);
	    ArrayList<String> adding = lettersOnNum(Integer.parseInt(last));
//		ArrayList<String> subresult = letterCombinations(sup);
//		ArrayList<String> adding = letterCombinations(first);
	    
	    for (String add : adding) {
	    	for (String shortter : subresult) {

	    		result.add(shortter + add);
	    	}
	    }    
	    return result;
    }
	
	private ArrayList<String> lettersOnNum(int n) {
		ArrayList<String>  result = new ArrayList<String>();
		if (n == 0) {
			System.out.println(n);
            System.exit(1);
		} else if ( n == 1) {
    		System.out.println(n);
            System.exit(1);
		} else if ( n == 2) {
			result.add("a");
			result.add("b");
			result.add("c");
		} else if ( n == 3) {
			result.add("d");
			result.add("e");
			result.add("f");
		} else if ( n == 4) {
			result.add("g");
			result.add("h");
			result.add("i");
		} else if ( n == 5) {
			result.add("j");
			result.add("k");
			result.add("l");
		} else if ( n == 6) {
			result.add("m");
			result.add("n");
			result.add("o");
		} else if ( n == 7) {
			result.add("p");
			result.add("q");
			result.add("r");
			result.add("s");
		} else if ( n == 8) {
			result.add("t");
			result.add("u");
			result.add("v");
		} else if ( n == 9) {
			result.add("w");
			result.add("x");
			result.add("y");
			result.add("z");
		} else {
			
		} 
		return result;
	}
		
	
	public static void main(String[] args) {
		String A = " ";
		Solution sol = new Solution();
		ArrayList<String> result = sol.letterCombinations(A);
		
		for (String each : result) {
			System.out.println(each);
		}
		System.out.println(result.size());
	}	    
}