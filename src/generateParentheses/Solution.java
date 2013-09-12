package generateParentheses;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String>result = new ArrayList<String>();
    	char[] str = new char[n*2];
    	generate(n, n, 0, str, result);
        return result;
    }
    
    public void generate(int n1, int n2, int count, char[] str, ArrayList<String>result) {
    	if (n1 < 0 || n2 < n1 )
    		return;
    	if (n1 == 0 && n2 == 0) {
    		result.add(new String(str));
    	}
    	else {	
    	if (n1 > 0) {
    			str[count] = '(';
        		generate(n1 - 1, n2, count+1, str, result);
    	}
    		if (n2 > n1) {
    			str[count] = ')';
    			generate(n1, n2 - 1, count+1, str, result);
    		}
    	}
    	return;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ArrayList<String>result = sol.generateParenthesis(3);
    	
    	for(String s: result) {
    		System.out.println(s);
    	}
    	
    }
   
}