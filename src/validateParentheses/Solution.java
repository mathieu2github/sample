package validateParentheses;

public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        char[] nums = s.toCharArray();
        int small = 0;
        int mid = 0;
        int big = 0;
        int flag = 0;
        
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == '(') {
                small++;
                if (small == 0) return false;
                if (big == 0 && mid == 0)
                    flag = 1;
            } else if (nums[i] == ')') {
                small--;
                if (small == 0 && flag == 1)
                	if (mid != 0 || big != 0)
                		return false;
            } else if (nums[i] == '[') {
                mid++;
                if (mid == 0) return false;
                if (big == 0 && small == 0)
                    flag = 2;
            } else if (nums[i] == ']') {
                mid--;
                if (mid == 0 && flag == 2)
                	if (small!= 0 || big != 0)
                		return false;
            } else if (nums[i] == '{') {
                big++;
                if (big == 0) return false;
                if (small == 0 && mid == 0)
                    flag = 3;
            } else if (nums[i] == '}') {
                big--;
                if (big == 0 && flag == 3)
                	if (mid != 0 || small != 0)
                		return false;
            } else {
                
            }
        } 
        if (small != 0 || mid != 0 || big != 0)
            return false;
        
        return true;
    }
}