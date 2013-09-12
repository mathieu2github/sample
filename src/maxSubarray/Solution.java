package maxSubarray;

import java.util.Arrays;

public class Solution {
	
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	return maxSubArray(A, 0, A.length - 1);
    }
    
    public int maxSubArray(int[] A, int l, int h) {
    	if (l == h) return A[l];
    	
    	int sum_l = Integer.MIN_VALUE;
    	int sum_h = Integer.MIN_VALUE;
    	int sum_mid = Integer.MIN_VALUE;
    	
    	int mid = (l + h) /2;
    	
    	int left = Integer.MIN_VALUE;
    	int right = Integer.MIN_VALUE;
    	int sum = 0;
    	for (int i = mid; i >=0; i--) {
    		sum +=A[i];
    		if (sum > left)
    			left = sum;
    	}
    	
    	sum = 0;
    	for (int i = mid +1; i <= h;i++) {
    		sum +=A[i];
    		if (sum > right)
    			right = sum;
    	}
    	
    	sum_mid = left + right;
    	sum_l = maxSubArray(A, 0, mid);
    	sum_h = maxSubArray(A,mid + 1,h);
    	
    	int[] result = {sum_mid,sum_l,sum_h};
    	Arrays.sort(result);
    	return result[2];
    	
    }
    
    
        public int maxSubArray2(int[] A) {
            // Start typing your Java solution below
            // DO NOT write main() function
            
            int len = A.length;
            
            int max_sofar = 0;
            int max_endhere = 0;
            
            for (int i = 0; i < len; i++) {
                max_endhere += A[i];
                if (max_endhere < 0) 
                    max_endhere = 0;
                else if (max_sofar < max_endhere)
                    max_sofar = max_endhere;
            }
            
            
            if (max_sofar == 0) {
                max_sofar = A[0];
                for (int i = 0; i < len; i++) {
                    if (A[i] <=0) {
                        if (max_endhere < A[i])
                            max_endhere = A[i];
                    }
                }
            }
            return max_sofar;
            
        }

    
    public static void main(String[] args) {
    	int[] A = {-9,-1,-1,-1,-1,-2,-1};
    	Solution sol = new Solution();
    	int sum = sol.maxSubArray2(A);
    	System.out.println(sum);
    }

}
