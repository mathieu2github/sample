package findFirstmissingPositive;
public class Solution {
    public int firstMissingPositive(int[] A) {

        if (A.length == 0) return 1;
      
        int i=0;
        while (i<A.length) {
            if (A[i]>=0 && A[i]<A.length) {
                if (A[i]!=i ) {
                	if (A[i]!=A[A[i]]) {
                        int temp = A[A[i]];
                        A[A[i]] = A[i];
                        A[i] = temp;
                        continue;
                	}

                }
            }
            i++;
        }
      
        for (i=1; i<A.length; i++) {
            if (i!=A[i]) return i;
        }
      
        if (A[0]==A.length) return A.length+1;
      
        return A.length;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] A = {9,8,6,4,3,2};
    	int n = sol.firstMissingPositive(A);
    	System.out.println(n);
    }
}