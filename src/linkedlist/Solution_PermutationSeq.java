package linkedlist;

import java.util.*;

public class Solution_PermutationSeq {
	
	public static void main(String[] args) {
		Solution_PermutationSeq sol = new Solution_PermutationSeq();
		
		for (int i = 0; i < 24; i++) {
			System.out.println( i + "--->" + sol.getPermutation(4,i));
		}
	}
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        String begin = "";
        for (int i = 1 ; i <= n ; i++) {
            begin += i;
        }
        
        ArrayList<String> results = getPermutation(begin);  
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        for (String ele : results) {
            Integer i = Integer.parseInt(ele);
            numbers.add(i);
        }
        Collections.sort(numbers);//wrong
        return numbers.get(k) + "";
        
    }
    
    public ArrayList<String> getPermutation(String begin) {
        ArrayList<String> result = new ArrayList<String>();
        if (begin.length() == 1)  {
        	result.add(begin);
            return result;
        }
            
        
        char c = begin.charAt(0);
        String sub = begin.substring(1);
        ArrayList<String> subresult = getPermutation(sub);
        result.addAll(process(subresult,c));   
        return result;
    }
    
    public ArrayList<String> process(ArrayList<String> subresult, char c) {
        ArrayList<String> result = new ArrayList<String>();
        
        for ( String element : subresult) {
            for ( int j = 0 ; j <= element.length(); j ++) {
                String start = element.substring(0,j);
                String end = element.substring(j);
                
                result.add(start + c + end);
                
            }
        }
        return result;     
    }
}