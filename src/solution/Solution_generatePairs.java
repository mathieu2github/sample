package solution;

import java.util.*;

public class Solution_generatePairs {
	    public ArrayList<String> generateParenthesis(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	    	
	    	ArrayList<String> result = new ArrayList<String>();
	        return generateParenthesis(n,n, result);
	        
	    }
	    
	    ArrayList<String> generateParenthesis(int j, int k, ArrayList<String> result) {
	    	genator(j,k,null, true,result);
	    	return result;

	    }
	    
	    String genator(int j, int k, String front, boolean mark, ArrayList<String> result) {
	    	if (mark == true) {
	    		mark = false;
	    		String begin = new String();
	    		return genator(j,k, begin, mark);
	    	}
	    	
	    	else {
	    		if ( j == k && k == 0)
	    			return front;
	    		if ( j > 0 ) {
	    			char c = '(';
	    			return genator(j - 1, k, front + c, false);
	    		}
	    		if ( k > j ) {
	    			char c = ')';
	    			return genator(j, k - 1, front + c, false);
	    		}
	    	}
	    	
	    }

	    

}
