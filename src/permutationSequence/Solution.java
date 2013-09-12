package permutationSequence;

import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	String s = new String();
    	for (int i = 1; i <=n; i++) {
    		s += i;
    	}
    	ArrayList<String> result = new ArrayList<String>();
        getPermutation("", s,result);
        return result.get(k);
    }
    
    public ArrayList<String> getResult(int n) {
    	String s = new String();
    	for (int i = 1; i <=n; i++) {
    		s += i;
    	}
    	ArrayList<String> result = new ArrayList<String>();
        getPermutation("", s,result);
        return result;
    }
    
    public void getPermutation(String prefix, String s, ArrayList<String> result) {
    	int n = s.length();
    	if (n == 0) {
    		result.add(prefix);
    	}    		
    	for (int i = 0; i < n; i++) {
    		getPermutation(prefix + s.charAt(i), s.substring(0,i) + s.substring(i+1,n),result);
    	}
    }
    
    public void print(String s) {
    	System.out.println(s);
    }
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int k = 9;
    	
    	int many = 1;
    	for (int i = k; i > 0; i--) {
    		many *=i;
    	}
    	
    	ArrayList<String> result = sol.getResult(k);
    	for (int i = 0; i < many;i++) {
    		sol.print(result.get(i));
    	}
    	for (int i = 0; i < many;i++) {
    		sol.print(sol.getPermutation(9, i));
    	}
    	
    }
}
