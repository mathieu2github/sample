package longestParlindrome;


public class Solution {
    public String longestPalindrome2(String a) {
    	int n = a.length();
    	char[] s = a.toCharArray();
    	int longestBegin = 0;
    	int maxLen = 1;
    	boolean[][] table = new boolean[1000][1000];
    	
    	for (int i = 0; i < n; i++) {
    		table[i][i] = true;
    	}
    	
    	for (int i = 0; i < n-1; i++) {
    		if (s[i] == s[i+1]) {
    			table[i][i+1] = true;
    			longestBegin = i;
    			maxLen = 2;
    		}
    	}
    	
    	for (int len = 3; len <= n; len++) {
    		for (int i = 0; i < n-len+1; i++) {
    			int j = i+len-1;
    			if (s[i] == s[j] && table[i+1][j-1]) {
    				table[i][j] = true;
    				longestBegin = i;
    				maxLen = len;
    			}
    		}
    	}
    	
    	return a.substring(longestBegin, longestBegin + maxLen);
    }
     
    public String expandFromMiddle (String s, int c1, int c2) {
    	char[] arr  = s.toCharArray();
    	int n1 = c1;
    	int n2 = c2;
    	while (n1 >= 0 && n2 <= s.length() - 1 && arr[n1] == arr[n2]) {
    		n1--;
    		n2++;
    	}
    	return s.substring(n1 + 1, n2);
    }
    public String longestPalindrome(String s) {
    	if ( s == null) return null;
    	if ( s.length() == 0) return null;
    	String longest = s.substring(0, 1);
    	for (int i = 0; i < s.length() - 1; i++) {
    		String exp1 = expandFromMiddle(s,i,i);
    		if (exp1.length() > longest.length())
    			longest = exp1;
    		String exp2 = expandFromMiddle(s,i,i+1);
    		if (exp2.length() > longest.length())
    			longest = exp2;
    	}
    	return longest;
    }
  
  
  public static void main(String[] args) {
	  Solution sol = new Solution();
	  String s = "banana";
	  String sub = new String(sol.longestPalindrome(s));
	  System.out.println(sub);
	  String s2 = "abnanab";
	  System.out.println(sol.expandFromMiddle(s2, 3, 3));
	  
  }
}