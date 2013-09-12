package linkedlist;

import java.util.ArrayList;

public class Solution_anagrams {
	
	public static void main(String[] args) {
		Solution_anagrams sol = new Solution_anagrams();
		ArrayList<String> result = sol.anagrams(args);
		for (String st: result) {
			System.out.print(st + "--->");
		}
	}
	
    public ArrayList<String> anagrams(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0 || strs.length == 1 ) return null;
        ArrayList<String> result = new ArrayList<String>();
        for ( int i = 0; i < strs.length - 1; i ++ ) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagrams(strs[i], strs[j])) {
                	if (!result.contains(strs[i]))
                		result.add(strs[i]);
            		if (!result.contains(strs[j]))
            			result.add(strs[j]);  
            	}       
            }
        }
        return result;  
    }
    
    private boolean isAnagrams (String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
            
        char[] string1 = s1.toCharArray();
        int[] stats = new int[256];
        int unique = 0;
        
        for (char c : string1) {
            if (stats[c] == 0 ) 
                unique++;
            stats[c]++;
        }
        
        for (int i = 0 ; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (stats[c] == 0) 
                return false;
            --stats[c];
            if ( stats[c] == 0)  {
                --unique;
                if (unique == 0)
                    return i == s2.length() - 1;
            }
                
        }
        return false;
    }
}