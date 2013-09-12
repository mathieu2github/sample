package nQueen;

import java.util.ArrayList;

public class Solution2 {
	
	
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> result = new ArrayList<String[]>();
        
        totalNQueens(n, result);
        return result;
    }
    
    public int totalNQueens(int n,  ArrayList<String[]> result) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        int[] columForRow = new int[n];
        return placeQueen(0, columForRow, result);
        
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
    
    
    private int placeQueen(int row, int[] pos,ArrayList<String[]> result) {
        int result2 = 0;
        if ( row >= pos.length) {
        	result.add(generateString(pos));
        	return 1;
        }
           
        for (int i = 0; i < pos.length; i++ ) {
            pos[row] = i;
            if (check (row, pos)) {
                result2 += placeQueen(row + 1, pos, result);
            }
        }    
        return result2;
    }
    
    private String[] generateString(int[] pos) {
    	int len = pos.length;
    	String[] result = new String[len];
    	for (int i = 0; i < len; i++) {
    		String ele = new String();
    		for (int j = 0; j < len; j++) {
        		if (pos[i] == j)
        			ele += "Q";
        		else
        			ele +=".";
        	}
    		result[i] = ele;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	ArrayList<String[]> result = new ArrayList<String[]>();
    	
    	for (int i = 1; i < 2; i++) {
    		result = sol.solveNQueens(8);
    		for (String[] s : result) {
        		for (int j = 0; j < s.length; j++) {
        			System.out.println(s[j]);
        		}
        	}
    	} 	
    }
}

