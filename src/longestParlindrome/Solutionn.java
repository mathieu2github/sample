package longestParlindrome;

public class Solutionn {
	public String longestPalindrome(String s) {
    	if ( s == null) return null;
    	if ( s.length() == 0) return null;
    	String longest = s.substring(0,1);
    	
    	for (int i =0; i < s.length() - 1; i++) {
    		String str1 = expandFromMid(s,i,i);
    		if (str1.length() > longest.length())
    			longest = str1;
    		String str2 = expandFromMid(s,i,i + 1);
    		if (str2.length() > longest.length())
    			longest = str2;	
    	}
    	return longest;
	}
	
	public String expandFromMid(String s, int n, int m) {
		int i = n;
		int j = m;
		
		while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j) ) {
			i--;
			j++;
		}
		
		return s.substring(i+1,j);
	}
	
	
	
	public static void main(String[] args) {
		  Solution sol = new Solution();
		  String s = "banana";
		  String sub = new String(sol.longestPalindrome(s));
		  
		  System.out.println("new solution");
		  
		  System.out.println(sub);
		  String s2 = "abnanab";
		  System.out.println(sol.expandFromMiddle(s2, 3, 3));
		  
	  }
}
