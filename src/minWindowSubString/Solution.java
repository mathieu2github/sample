package minWindowSubString;

public class Solution {
	
	   public String minWindow(String S, String T) {
	        if (S.length() < T.length() || T.length()==0) return "";
	        String minStr = S+" "; 
	        S.toUpperCase();
	        T.toUpperCase();

	       // -- cnt arrays used for judging whether all characters 
	       //  in target string are included in window sub-string.
	        int[] wndCnts = new int[26];
	        int[] tgtCnts = new int[26];
	      
	        char[] temp = T.toCharArray();
	        for (char c: temp) {
	            tgtCnts[c-'A'] ++;
	        }
	      
	        int loadFlag = setFlag(T);
	        int loadFlagCopy = loadFlag;
	      
	        int head, tail;
	        head = tail =0;
	      
	        // -- skip letters that not meaningful --
	        while (!charInTarget(S.charAt(head), tgtCnts)) { 
	         head++;
	        };       
	        tail = head;
	      
	        // -- start looping --
	        while (head < S.length() ) {
	            while (!charInTarget(S.charAt(tail), tgtCnts)) { 
	             tail++;
	            };
	          
	            // -- grow to the match --
	            while (head < S.length() && loadFlag!=0) {
	                char c= S.charAt(head++);
	                if (charInTarget(c, tgtCnts)) {
	                    wndCnts[c-'A']++;
	                    if (wndCnts[c-'A']==tgtCnts[c-'A']) {
	                        loadFlag ^= 1<<(c-'A');
	                    }
	                }               
	            }

	            if (loadFlag == 0) {
	                if (minStr.length()>head-tail) {
	                    minStr = S.substring(tail, head);
	                }
	            }
	            else break;
	          
	            // -- reduce the match --
	            int unloadFlag = 0;
	            while(tail<head && unloadFlag==0) {
	                char c= S.charAt(tail++);
	                if (charInTarget(c, tgtCnts)) {
	                    wndCnts[c-'A']--;
	                    if (wndCnts[c-'A']<tgtCnts[c-'A']) {
	                        unloadFlag = 1<<(c-'A');
	                    }
	                    else if (minStr.length()>head-tail) {
	                        minStr = S.substring(tail, head);
	                    }
	                }
	            }
	          
	            loadFlag = loadFlagCopy & unloadFlag;
	        }
	      
	        if (minStr.equals(S+" ")) return "";
	        return minStr;
	    }
	  
	    int setFlag (String s) {
	        char[] chars = s.toCharArray();
	        int a = 0;
	        for (char c: chars) {
	            a |= 1<<(c-'A');
	        }
	        return a;
	    }
	  
	    boolean charInTarget (char c, int[] target) {
	        return (target[c-'A']>0);
	    }
	    
	    public static void main(String[] args) {
	    	String S = "ADOBECODEBANC";
	    	String T = "ABC";
	    	Solution sol = new Solution();
	    	System.out.println(sol.minWindow(S, T));
	    }

}
