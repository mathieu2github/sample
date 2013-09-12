package lengthLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if ( s.length() == 0)
            return 0;
        int previous = 0;
        
        int current = 0;
        
        char[] words = s.toCharArray();
        
        for ( int i = 0; i < words.length; i++) {

            if (words[i] == ' ') {
                if ( current != 0) {
                    previous = current;
                    current = 0;
                }

                if ( i == words.length - 1)
                    return previous;
            } else {
                current++;      
             }
        }
        return current;
    }
	
	public static void main(String[] args) {
		String s = "   " ;
		
		Solution sol = new Solution();
		int n = sol.lengthOfLastWord(s);
		System.out.println(n);
	}
}
