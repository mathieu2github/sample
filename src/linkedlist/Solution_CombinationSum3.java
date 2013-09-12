package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_CombinationSum3 {

	

	    public ArrayList<ArrayList<Integer>> combinationSum3(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Arrays.sort(num);
	        return combinationSum3(num, target, num.length - 1);
	    }
	    
	    
	    public ArrayList<ArrayList<Integer>> combinationSum3(int[] num, int target, int index) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        
	        if (index == 0) {
	            if (target == num[index] || target == 0) {
	            		ArrayList<Integer> lowest = new ArrayList<Integer>();
	                    if (target == num[index])
	                        lowest.add(num[index]);
	            		result.add(lowest);
	            	}
	            return result;
	        }
	        
	        if (target - 1 * num[index] >=0) {
	             ArrayList<ArrayList<Integer>> sub = combinationSum3(num, target - 1 * num[index], index - 1);
	                for ( ArrayList<Integer> elements : sub) {
	                        elements.add(num[index]);
	                    }
	                result.addAll(sub);
	        }
	        ArrayList<ArrayList<Integer>> sub = combinationSum3(num, target, index - 1);
	        result.addAll(sub);
	         
	        return result;
	       
	    }
	    
	    public static void main(String[] args) {
	    	int[] para = {10,1,2,7,6,1,5};
	    	Solution_CombinationSum3 sol = new Solution_CombinationSum3();
	    	ArrayList<ArrayList<Integer>> result = sol.combinationSum3(para, 8);
	    	if (result == null) return;
	    	for (ArrayList<Integer> sub : result) {
	    		System.out.println(sub.toString());
	    	}
	    }
}