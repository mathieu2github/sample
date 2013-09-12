package findKthTwoSortedArrays;

public class Solution {
	 public static int findKthElementOfArrays(int[] a, int[] b, int k) {
	        assert k>0;
	        assert a.length + b.length >= k;
	       
	        int low = Math.max(0, k-b.length);
	        int high= Math.min(k, a.length);
	        int m = 0;
	       
	        while (low < high) {
	            m = low + (high-low)/2;
	           
	            if (k-m-1>=0 && a[m]<b[k-m-1]) {
	                low = m+1;
	            }
	            else if (m>0 && k-m <b.length && b[k-m]<a[m-1]) {
	                high = m;
	            }
	            else {
	                low = m;
	                break;
	            }
	        }
	        if (low == 0) return b[k-1];
	        if (low == k) return a[k-1];
	        return Math.max(a[low-1], b[k-low-1]);
	    }
	 
	 public static void main(String[] args) {
		 int[] a = {1,2,3,4,5,6,7,8,11,13,15,19,24,26,29};
		 int[] b = {1,2,4,6,7,8,9,11,14,19,31,32,35};
		 Solution sol = new Solution();
		 
		 System.out.println(sol.findKthElementOfArrays(a, b, 11));
	 }

}
