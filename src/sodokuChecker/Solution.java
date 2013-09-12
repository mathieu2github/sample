package sodokuChecker;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return true;
    }
    
    private boolean check_row(char[][] board) {
        if (board == null || board.length != 9)
            return false;
        int length = board.length;
        
        for ( int i = 0; i < length; i++) {
            
        }
    }
    
    private boolean check_col(char[][] board) {
        
    }
    
    private boolean check_nine(char[] numbers) {
        if (numbers == null || numbers.length != 9)
            return false;
        Set<Character> standard = new HashSet<Character>();
        standard.add(1);
        standard.add(2);
        standard.add(3);
        standard.add(4);
        standard.add(5);
        standard.add(6);
        standard.add(7);
        standard.add(8);
        standard.add(9);
        for (int i = 0; i < numbers.length; i++) {
            if (!standard.remove(number[i])
                return false;
        }
        
        return true;
        
    }
}