package longestValidParentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        char[] array = s.toCharArray();
        
        int len = 0;
        int maxlenth1 = 0;
        int maxlenth2 = 0;
        int count = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (array[i] == '(') {
                count++;len++;
            }
            if (array[i] == ')') {
                count--;len++;
            }

            if (count == 0 && maxlenth1 < len) {
            	maxlenth1 = len;
            }
                
            if (count < 0) {
                count = 0;
                len =0;
            }
        }
        
        count = 0;
        len = 0;
        for (int i = n - 1; i >= 0; i--) {
        	if (array[i] == ')') {
        		count++;len++;
        	}
        	if (array[i] == '(') {
        		count--;len++;
        	}
        	if (count == 0 && maxlenth2 <= len) {
        		maxlenth2 = len;
        	}
        	if (count < 0) {
        		count = 0;
        		len = 0;
        	}
        	
        }
        return maxlenth1 > maxlenth2 ? maxlenth1 : maxlenth2;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	
//    	String s = new String(")(((((()())()()))()(()))(");
    	String s = new String("(())((()))");
    	int n = sol.longestValidParentheses(s);
    	System.out.println(n);
    }
}