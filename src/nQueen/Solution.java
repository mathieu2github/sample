package nQueen;

public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        int[] columForRow = new int[n];
        return placeQueen(0, columForRow);
        
    }
    
    
//    private boolean check(int row, int[] pos) {
//        for (int i = 0; i < row ; i++) {
//            int diff = Math.abs(pos[row] - pos[i]);
//            if (diff == 0 || diff == row - i)
//                return false;
//        }
//        return true;
//    }// queen checking
    
    private boolean check(int row, int[] pos) {
    	if (row > 0) {
    		int diff = Math.abs(pos[row] - pos[row - 1]);
    		if (diff <= 1)
    			return false;
    	}
    	
        for (int i = 0; i < row - 1 ; i++) {
            int diff = Math.abs(pos[row] - pos[i]);
            if (diff == 0)
                return false;
        }
        return true;
    }// king checking
    
    
    private int placeQueen(int row, int[] pos) {
        int result = 0;
        if ( row >= pos.length) 
            return 1;
        for (int i = 0; i < pos.length; i++ ) {
            pos[row] = i;
            if (check (row, pos)) {
                result += placeQueen(row + 1, pos);
            }
        }    
        return result;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	for (int i = 1; i < 20; i++) {
    		System.out.println( i + " times " + i + " grid has " + sol.totalNQueens(i) + " possible ways");
    	}
    	
    }
}

