package subsets;
import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        return subsets(S, S.length);
        
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S, int index) {
        ArrayList<ArrayList<Integer>> result;
        
        if ( index == 0) {
            result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        int c = S[index - 1];
        result = subsets(S,index - 1);
        ArrayList<ArrayList<Integer>> more = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> element : result) {
            ArrayList<Integer> xinde = new ArrayList<Integer>();
            xinde.addAll(element);
            xinde.add(c);
            more.add(xinde);
        }
        result.addAll(more);
        return result;
    }

    public static void main(String[] args) {
    	int[] sample = {1,2,3,4};
    	Solution sol = new Solution();
    	ArrayList<ArrayList<Integer>> result = sol.subsets(sample);
    	for ( ArrayList<Integer> ele : result) {
    		System.out.println(ele.toString());
    	}
    }
}