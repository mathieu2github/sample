package longestCommonPrefix;
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
    	int index = 0;
    	if (strs == null) return "";
    	if (strs.length == 0) return "";
    	if (strs.length == 1) return strs[0];
    	
    	index = 0;
    	
    	boolean has_diff_char = false;
    	
    	while (!has_diff_char) {
    		if (strs[0].length() <= index) break;
    		char ch = strs[0].charAt(index);
    		
    		for (i = 1; i < strs.length;i++) {
    			if (strs[i].charAt(index)!=ch || strs[i].length()<=index) {
    				has_diff_char = true;
    				break;
    			}
    		}
    		if (!has_diff_char)
    			index++;
    	}
    	
    	return strs[0].substring(0,index);
    }


    
    public static void main(String[] args) {
//    	String[] sample = {"a","a","b"};
//    	Solution sol = new Solution();
//    	System.out.println("start");
//    	System.out.println(sol.longestCommonPrefix(sample));
//    	System.out.println("over");
    	
//    	int a = (int) 3.5;
    	int a1 = 5;
    	double a2 =(float) a1;
    	int a = 9/0;
    	System.out.println(a2);
    	System.out.println(a1);
    	System.out.println(a);


    }
}