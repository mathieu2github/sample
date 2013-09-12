package linkedlist;

import java.util.*;

public class Solution_CombinationSum {
//    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        
//        for (int i = 0; i < candidates.length; i++) {
////            if (target < candidates[i]) {
////            	ArrayList<Integer> base = new ArrayList<Integer>();
////            	result.add(base);
////            }
//            if (target > candidates[i]) {
//                ArrayList<ArrayList<Integer>> subResult = combinationSum(candidates, target - candidates[i]);
//                for (ArrayList<Integer> elements : subResult) {
//                		elements.add(candidates[i]);
//                }
//                result.addAll(subResult);
//            }  
//            if (target == candidates[i]) {
//            	ArrayList<Integer> base = new ArrayList<Integer>();
//            	base.add(candidates[i]);
//            	result.add(base);
//            }
//        }
//        return result;
//    }
    
   
        public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
            // Start typing your Java solution below
            // DO NOT write main() function
        	Arrays.sort(candidates);
            return combinationSum(candidates, target, candidates.length - 1);
            
        }
        
        
        public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int index) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            
            if (index == 0) {
            	if (target % candidates[index] == 0) {
            		ArrayList<Integer> lowest = new ArrayList<Integer>();
            		for (int j = 0; j < target/candidates[index]; j++) {
            			lowest.add(candidates[index]);
            		}
            		result.add(lowest);
            	}
            	return result;
            }
            
            for ( int i = 0; candidates[index] * i <= target; i ++ ) {
                ArrayList<ArrayList<Integer>> sub = combinationSum(candidates, target - i * candidates[index], index - 1);
                for ( ArrayList<Integer> elements : sub) {
                    for (int j = 0; j < i ; j++) {
                        elements.add(candidates[index]);
                    }
                }
                result.addAll(sub);           
            }
            return result;
        }
    
    
    
    
    public static void main(String[] args) {
//    	int[] para = {1,5};
//    	Solution_CombinationSum sol = new Solution_CombinationSum();
//    	ArrayList<ArrayList<Integer>> result = sol.combinationSum(para, 10);
//    	if (result == null) return;
//    	for (ArrayList<Integer> sub : result) {
//    		System.out.println(sub.toString());
//    	}
    	
    	int[] para = {10,1,2,7,6,1,5};
    	Solution_CombinationSum3 sol = new Solution_CombinationSum3();
    	ArrayList<ArrayList<Integer>> result = sol.combinationSum3(para, 8);
    	if (result == null) return;
    	for (ArrayList<Integer> sub : result) {
    		System.out.println(sub.toString());
    	}
    }
}