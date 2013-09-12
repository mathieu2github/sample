package subset;

import java.util.*;

public class Solution {
	
	
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        Arrays.sort(S);
        
        return subsets(S,S.length-1);
        
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S, int n) {
        if (n == 0) {
            ArrayList<Integer> element = new ArrayList<Integer>();
            //ArrayList<Integer> element2 = new ArrayList<Integer>();

            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            result.add(element);
            element.add(S[n]);
            result.add(element);
            return result;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<ArrayList<Integer>> sub = subsets(S, n - 1);
        
        result.addAll(sub);
        for (ArrayList<Integer> element : sub) {
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.addAll(element);
            single.add(S[n]);
            result.add(single);
        }       
       return result;       
    }
    
    
    public static void main(String[] args) {
    	int[] sample = {1,2,3};
    	
    	Solution sol = new Solution();
    	
    	ArrayList<ArrayList<Integer>> result = sol.subsets(sample);
    	
    	for (ArrayList<Integer> ele : result) {
    		System.out.println(ele.toString());
    	}
    	
    	
    	String a = "foo";
    	String b = "food".substring(0, 3);
    	String c = b.intern();

    	if (a.equals(b)) {
    	    if (a == b) {
    	        System.out.println("1");
    	    } else if (a == c) {
    	        System.out.println("2");
    	    } else {
    	        System.out.println("3");
    	    }
    	} else {
    	    System.out.println("4");
    	}


    	
    }
    
    
    
}