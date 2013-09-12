package coinChange;

public class Solution {
	
	public int coinChange(int[] s, int m, int n) {
		if (n == 0)
			return 1;
		if (n < 0 )
			return 0;
		if (m <= 0 && n >= 0)
			return 0;
		return coinChange(s,m - 1, n) + coinChange(s, m , n - s[m-1]);
	}
	
	public static void main(String[] args) {
		int[] s = {1,2,3};
		int n = (new Solution()).coinChange(s, s.length, 4);
		System.out.println(n);

	}

	

}
