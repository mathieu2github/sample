package longestCommonSubseq;

public class Solution {
	
	public int longestCommonSubseq(String s1, String s2) {
		return longestCommonSubseq(s1, s2, s1.length() , s2.length() );
	}
	
	
	public int longestCommonSubseq(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (s1.charAt(n-1) == s2.charAt(m-1))
			return 1 + longestCommonSubseq(s1, s2, n - 1, m - 1);
		else
			return longestCommonSubseq(s1, s2, n, m - 1) > longestCommonSubseq(s1, s2, n - 1, m)
					? longestCommonSubseq(s1, s2, n, m - 1) : longestCommonSubseq(s1, s2, n - 1, m);
	}
	
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		
		Solution sol = new Solution();
		
		System.out.println(sol.longestCommonSubseq(s1, s2));
	}

//	
//	 char X[] = "AGGTAB";
//	  char Y[] = "GXTXAYB";
}
