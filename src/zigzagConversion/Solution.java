package zigzagConversion;

public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	if (nRows == 1)return s;
    	if (nRows == 2) {
    		String result ="";
    		for (int i = 0;i < s.length();i++) {
    			result += s.charAt(i++);
    		}
    		for (int i = 1;i < s.length();i++) {
    			result += s.charAt(i++);
    		}
    		return result;
    	}
    	StringBuffer res = new StringBuffer();
    	int limit =  nRows*2-2;
    	boolean even = s.length() % limit == 0;
    	int parts;
    	if (even)
    		parts = s.length()/limit;
    	else
    		parts = s.length()/limit + 1;
    	    	
    	if (even) {
    		for (int i = 0; i < nRows ;i++) {
    			for (int j = 0; j < parts; j++) {
    				res.append(s.charAt(j*limit + i));
    				if (i >0 && i <nRows - 1) {
    					res.append(s.charAt(j*limit + 2*nRows - i - 1-1));
    				}	
    			}
    				
    		}
    		return res.toString();
    	} else {
    		for (int i = 0; i < nRows ;i++) {
    			for (int j = 0; j < parts; j++) {
    				if (j == parts - 1) {
    					if(j*limit+i <s.length()) {
    						res.append(s.charAt(j*limit + i));
    		
    					}
    					if (i >0 && i <nRows-1&&(j*limit + 2*nRows - i -1 -1)<s.length()) {
    					
    						res.append(s.charAt(j*limit + 2*nRows - i - 1 -1));
    						continue;
    					}
    						continue;
    				}
    				res.append(s.charAt(j*limit + i));
    				if (i != 0 && i !=nRows - 1) {
    					res.append(s.charAt(j*limit + 2*nRows - i - 1-1));
    				}		
    			}		
    		}
    		return res.toString();
    	}
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();

    	System.out.println("obforctuqbjyktmayqnqkhxytarwvdyjfda");
    	
    	System.out.println(sol.convert("ABCDE", 4));
    }

}
