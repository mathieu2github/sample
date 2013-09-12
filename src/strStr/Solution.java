package strStr;

public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (haystack == "" && needle == "") return "";
        if (haystack == "") return null;
        if (needle == "") return haystack;
        if (haystack.length() < needle.length())
            return null;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for ( int j = 0; j< needle.length(); j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    if (j == needle.length() - 1)
                		return haystack.substring(i);
                } else
                	break;
            }
            
        }
        return null;
    }
    
    public String strStr2(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++ ) {
                for (int j = 0;j < needle.length();j++) {
                    if (haystack.charAt(i+j) == needle.charAt(j)) {
                        if ( j == needle.length() - 1) {
                            return haystack.substring(i);           		
                        }
                        continue;
                    } else
                        break;
                }
        }
        return null;
    }
    
    public static void main(String[] args) {
    	String haystack = "abcbcbcbc";
    	String needle = "b";
    	Solution sol = new Solution();
    	System.out.println(sol.strStr(haystack, needle));
    	System.out.println(sol.strStr2(haystack, needle));

    }
}