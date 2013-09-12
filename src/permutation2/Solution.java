package permutation2;

import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function 
        Map<Integer, Integer> elements = new Hashtable<Integer,Integer>();
        for (int i = 0; i < num.length ; i ++ ) {
            if (!elements.containsKey(num[i]))
                elements.put(num[i],1);
            else {
                int times = elements.get(num[i]);
                times++;
                elements.put(num[i], times);
            }
                
        } 
        
        int[] yuanshu = new int[elements.size()];
        Iterator<Integer> itr = elements.keySet().iterator();
        int i = 0;
        while(itr.hasNext()) {
        	yuanshu[i] = itr.next();
        	i++;
        }
        return permute(elements, yuanshu,yuanshu.length - 1); 
        
    }
    
     public ArrayList<ArrayList<Integer>> permute(Map<Integer, Integer> elements, int[] yuanshu,int index) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         if (index == 0) {
        	 ArrayList<Integer> entry = new ArrayList<Integer>();
        	 for (int i = 0; i < elements.get(yuanshu[index]); i++)
        		 entry.add(yuanshu[index]);
        	 result.add(entry);
        	 return result;
         } else {
        	 int c = yuanshu[index];
        	 int times = elements.get(c);
        	 elements.remove(c);
        	 index--;
             ArrayList<ArrayList<Integer>> subresult = permute(elements,yuanshu,index);
             
             for (int i = 0; i < times;i++) {
                 for (ArrayList<Integer> number : subresult) {
                     for (int j = 0; j <= number.size(); j ++) {
                         result.add(process(j,number, c));
                     }
                 }
             }
             return result; 
         }
         
             
     }
     
     private ArrayList<Integer> process (int j, ArrayList<Integer> sub, Integer c) {
    	 ArrayList<Integer> xinde = new ArrayList<Integer>();
    	 xinde.addAll(sub);
    	 xinde.add(j,c);
    	 return xinde;
     }
     
     public static void main(String[] args) {
    	 int[] sample = {1,2,3,3,5,5,2};
    	 Solution sol = new Solution();
    	 ArrayList<ArrayList<Integer>> result = sol.permuteUnique(sample);
    	 for (ArrayList<Integer> ele : result) {
    		 System.out.println(ele.toString());
    	 }
     }
     

        
}