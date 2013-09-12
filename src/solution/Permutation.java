package solution;

import java.util.ArrayList;
public class Permutation {
	
	    public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<Integer> aArray = new ArrayList<Integer>();
	        for (int i = 0; i < num.length; i++) {
	            aArray.add(num[i]);
	        }        
	        return permute(aArray, aArray.size());
	    }
	        
	    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> aArray, int n) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        
	        if ( n == 1) {
	            ArrayList<Integer> first = new ArrayList<Integer>();
	            first.add(aArray.get(n-1));
	            result.add(first);
	            return result;
	        }   
	        else {
	            ArrayList<ArrayList<Integer>> subResult = permute(aArray, n - 1);
	            int element = aArray.get(n - 1);    
	            for (ArrayList<Integer> item : subResult) {
	                for (int i = 0; i < n ; i++) {
	                    ArrayList<Integer> sub = new ArrayList<Integer>();
	                    sub.addAll(item);
	                    sub.add(i,element);
	                    result.add(sub);
	                }    
	            }
	            return result;     
	        }       
	    }
	    
	    public static void main(String[] args) {
	    	int[] sample = {1,2,3};
	    	Permutation p = new Permutation();
	    	ArrayList<ArrayList<Integer>> res = p.permute(sample);
	    	for (int i = 0; i <res.size(); i++) {
	    		System.out.println(res.get(i).toString());
	    	}
	    	
	    }

}
