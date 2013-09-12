package linkedlist;
import java.util.ArrayList;

public class Solution_combine {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if ( n <=0 || k <= 0) return null;
        if ( n < k ) return null;
        if ( n == k )  {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for (int i = 1; i <= n ; i ++ ) {
             sub.add(i);
            }
            result.add(sub);
            return result;
        }
        
        if ( k == 1 ) {
            for ( int i = 1; i <= n ; i ++) {
                ArrayList<Integer> lowest = new ArrayList<Integer>();
                lowest.add(i);
                result.add(lowest);
            }
            return result;
        }
        
        if ( k > 1 ) {
             ArrayList<ArrayList<Integer>> sub = combine(n-1 , k -1);
             ArrayList<ArrayList<Integer>> sub2 = combine(n - 1, k);
             for ( ArrayList<Integer> lowest : sub) {
                 lowest.add(n);
                 result.add(lowest);
             }
             result.addAll(sub2);
             return result;
        }      
        return result;
    }
    
    public static void main(String[] args) {
    	Solution_combine sol = new Solution_combine();
    	ArrayList<ArrayList<Integer>> result = sol.combine(20, 5);
    	if (result == null) return;
    	for (ArrayList<Integer> sub : result) {
    		System.out.println(sub.toString());
    	}
    	
    }
}