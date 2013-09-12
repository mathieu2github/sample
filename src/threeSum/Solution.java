package threeSum;

import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
                
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            int a = num[i];
            int k = i + 1;
            int l = num.length - 1;
            
            while (k<l) {
                int b = num[k];
                int c = num[l];
                if (a + b + c == 0) {
                    ArrayList<Integer> element = new ArrayList<Integer>();
                    element.add(a);
                    element.add(b);
                    element.add(c);
                    if (!result.contains(element))
                    result.add(element);
                    k+=1;
                    l-=1;
                } else if ( a + b + c < 0) {
                    k +=1;
                } else {
                    l -=1;
                }
            }
        }
            
        return result;
    }


    public static void main(String[] args) {
    	int[] A = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
    	Solution sol = new Solution();
    	ArrayList<ArrayList<Integer>> res = sol.threeSum(A);
    	for (ArrayList<Integer> item : res) {
    		System.out.println(item.toString());
    	}
    }
}
