package maxRectangleInMatrix;

public class Solution {
	
	 public int maximalRectangle(char[][] matrix) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	     int row = matrix.length;
	     int col = matrix[0].length;
	     
	     int[][] sub = new int[row][col];
	     
	     for (int i = 0;i< row; i++) {
	    	 sub[i][0] = charToInt(matrix[i][0]);
	     }
	     
	     for (int i = 0;i< col; i++) {
	    	 sub[0][i] = charToInt(matrix[0][i]);
	     }
	     
	     for (int i = 1;i< row; i++) {
	    	 for (int j = 1;j < col; j++) {
	    		 if (matrix[i][j] == '1') {
	    			 if ( i == 4 && j == 3) {
	    				 @SuppressWarnings("unused")
						int wuyiyi = 0;
	    				 wuyiyi++;
	    			 }
	    			 int mm =  minFromThree(sub[i-1][j-1],sub[i][j-1],sub[i-1][j]);
	    			 sub[i][j] = mm +1;
	    			 }
	    			
	    		 else
	    			 sub[i][j] = 0;
	    	 }
	     }
	     
	     int max = 0;
	     for (int i = 1;i< row; i++) {
	    	 for (int j = 1;j < col; j++) {
	    		 max = sub[i][j] > max ? sub[i][j] : max;
	    	 }
	     }
	     return max * max;// square area , not rectangle area;        
	    }
	    
	    private int minFromThree(int n1, int n2,int n3) {
//	        String s1 = new String(c1 + "0");
//	        String s2 = new String(c2 + "0");
//	        String s3 = new String(c3 + "0");
//	        int n1 = Integer.parseInt(s1);
//	        int n2 = Integer.parseInt(s2);
//	        int n3 = Integer.parseInt(s3);
	    	if ( n1 <= n2) {
	    		if (n1 <= n3)
	    			return n1;
	    		return n3;
	    	} else {
	    		if (n2 <= n3)
	    			return n2;
	    		return n3;
	    	} 	
	    }
	    
	    private int charToInt(char c) {
	    	char[] arr = {c, '0'};
	    	String s = new String(arr);
	    	return Integer.parseInt(s)/10;
	    }

}
