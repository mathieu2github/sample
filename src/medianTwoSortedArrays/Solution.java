package medianTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int n = A.length;
        int m = B.length;
        int target = 0;
        
        if (( n + m) % 2 == 1) {
            target = (n+m)/2 + 1;
        } else 
            target = (n + m) /2;
            
        int i = 0;
        int j = 0;
        int l = 0;
        double value = -1;
        for ( l = 0; l <= target && i< n && j<m;l++) {
            if ( A[i] <= B[j] ) {
                i++;
                if (l == target)
                    value = A[i-1];
            }
                
            else {
                j++;
                if (l == target)
                    value = B[j-1];
            }
                
        }
        
        if ( l > target) {
            if (( n + m) /2 == 1)
                return value;
            else {
                double another = - 1;
                another = A[i] < B[j] ? A[i] : B[j];
                return (value + another) / 2;
            }
        }
        
        if ( i == n ) {
            while ( l <= target) {
                j++;
            }
            if (( n + m) /2 == 1)
                return B[j];
            else {
                int another = - 1;
                j++;
                another = A[i] < B[j] ? A[i] : B[j];
                return (B[j] + another) / 2;
            }
        }
        
        if ( j == m) {
            while (l <= target) {
                i++;
            }
            if (( n + m) /2 == 1)
                return A[i];
            else {
                int another = - 1;
                i++;
                another = A[i] < B[j] ? A[i] : B[j];
                return (A[i] + another);
            }
        }
        return 0;     
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] A = {1,2,3,4,5,6};
    	int[] B = {2,3,4,5,6,7};
    	
    	double n = sol.findMedianSortedArrays(A, B);
    	System.out.println(n);
    	double m = 9.0/2;
    	System.out.println(m);
    	
    	
    }
}