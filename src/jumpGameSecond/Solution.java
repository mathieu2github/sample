package jumpGameSecond;

public class Solution {
	
	public int jumps(int[] A) {
		
		
		return jumps(A,0, A.length - 1);
	}
	
	// natural recursive solution
	private int jumps(int[] a, int l, int h) {
		// TODO Auto-generated method stub
		if ( l == h)
			return 0;
		
		if (a[l] == 0)
			return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		for (int i = l+1; i <= a[l] + l && i <=h ;i++) {
			int jumps = jumps(a, i, h);
			if (jumps!=Integer.MAX_VALUE)
				min = jumps + 1 < min ? jumps + 1: min;
		}
		return min;
	}
	
	public int jumps1(int[] A) {
		int[] minJumps = new int[A.length];
		int i = 0;
		int j;
		
		if (A[0] == 0) return Integer.MAX_VALUE;
		minJumps[0] = 0;
		
		for (i = 1; i < A.length; i++) {
			minJumps[i] = Integer.MAX_VALUE;
			for (j=0; j < i; j++) {
				if (A[j] + j >= i) {
					minJumps[i] = minJumps[j] + 1;
					break;
				}
			}
		}
		
		return minJumps[--i];
	}
	
	public int jumps2(int[] A) {
		int[] minJumps = new int[A.length];
		int i,j;
		
		minJumps[A.length - 1] = 0;
		
		for ( i = A.length - 2; i >=0; i--) {
			minJumps[i] = Integer.MAX_VALUE;
			if (A[i] + i >= A.length - 1)
				minJumps[i] = 1;
			else if (A[i] ==0) {
				minJumps[i] = Integer.MAX_VALUE;
			} else {
				int min = Integer.MAX_VALUE;
				for ( j = i + 1; j <= i+A[i] && j <= A.length - 1;j++) {
					if (minJumps[j]!= Integer.MAX_VALUE) {
						min = minJumps[j] < min ? minJumps[j] : min;
						minJumps[i] = min +1;
					}
				}
				//minJumps[i] = min +1; cant put this line here. over flow happens here!
			}
		}
		
		return minJumps[0];
	}
	
	public static void main(String[] args) {
		int[] A = {3,4,3,1,0,7,0,3,0,2,0,3};
		Solution sol = new Solution();
		int n_steps = sol.jumps2(A);
		System.out.println(n_steps);
	}
	
	

}
