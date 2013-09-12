package solution;

import java.util.*;

public class Solution_Permutation {
	
	 public static ArrayList<ArrayList<Integer>> generatePermutations ( ArrayList<Integer> nums ) {
		  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();

		  if (nums.isEmpty()) return null;
		  
		  if (nums.size()==1) {
		   result.add(nums);
		   return result;
		  }
		  
		  Integer a = nums.get(0);
		  int numSize = nums.size();
		  nums.remove(0);
		  List<ArrayList<Integer>> subPerms = generatePermutations(nums);
		  
		  for (int i=0; i<subPerms.size(); i++) {
		   for (int j=0; j<numSize; j++) {
		    ArrayList<Integer> newPerm = new ArrayList<Integer> (subPerms.get(i));
		    newPerm.add(j, a);
		    result.add(newPerm);
		   }
//		   ArrayList<Integer> newPerm = new ArrayList<Integer> (subPerms.get(i));
//		   newPerm.add(a);
//		   result.add(newPerm);
		  }
		  return result;
		 }
	
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> elements = new ArrayList<Integer>();
        for (int i = 0; i < num.length ; i ++ ) {
            elements.add(num[i]);
        }     
      //  return permute(elements); 
       return this.generatePermutations ( elements );
    }
    
     public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> elements) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         if (elements.size() == 1) {
             result.add(elements);
             return result;
         }
         
         Integer c = elements.remove(0);
         ArrayList<ArrayList<Integer>> subresult = permute(elements);
         
         for (ArrayList<Integer> number : subresult) {
             for (int j = 0; j <= number.size(); j ++) {
                 result.add(process(j,number, c));
             }
         }   
         
         return result;    
     }
    
//    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> elements) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        if (elements.size() == 1) {
//            result.add(elements);
//            return result;
//        } else {
//        	Integer c = elements.remove(0);
//            result = permute(elements);
//            
//            for (ArrayList<Integer> number : result) {
//                for (int j = 0; j <= number.size(); j ++) {
//                    //result.add(process(j,number, c));
//                    ArrayList<Integer> xinde = new ArrayList<Integer>();
//                    xinde.addAll(number);
//                    xinde.add(j,c);
//                    result.add(xinde);
//                }
//                result.remove(number);
//            }   
//            return result;    
//        }
//        
//        
//    }
     
     private ArrayList<Integer> process (int j, ArrayList<Integer> sub, Integer c) {
    	 ArrayList<Integer> xinde = new ArrayList<Integer>();
    	 xinde.addAll(sub);
    	 xinde.add(j,c);
    	 return xinde;
     }
     
     public static void main(String[] args) {
    	 int[] para = {1,2,3,4};
    	 Solution_Permutation sol = new Solution_Permutation();
    	 ArrayList<ArrayList<Integer>> result = sol.permute(para);
    	 for (ArrayList<Integer> element : result) {
    		 System.out.println(element);
    	 }
    	 
     }
     
}