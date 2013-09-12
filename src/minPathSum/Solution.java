package minPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int m = grid.length;
        int n = grid[0].length;
        
        
        return minPathSum(grid, m - 1, n - 1);
        
    }
    
    public int minPathSum(int[][] grid, int m, int n) {
        if ( m < 0 || n < 0)
            return Integer.MAX_VALUE;
        
        if ( m == 0 && n == 0) 
            return grid[0][0];
        
//        int upper = minPathSum(grid, m - 1, n);
//        int left = minPathSum(grid, m , n - 1);
//        
//        if ( upper < left)
//        	return grid[m][n] + upper;
//        return grid[m][n] +  left;
        
        return grid[m][n] + (minPathSum(grid, m - 1, n) < minPathSum(grid, m , n - 1) ?
        		 minPathSum(grid, m - 1, n)  : minPathSum(grid, m , n - 1));
    }
    

        public int minPathSum2(int[][] grid) {
            // Start typing your Java solution below
            // DO NOT write main() function
            
            return minPathSum2(grid, grid.length, grid[0].length);
            
        }
        
        public int minPathSum2(int[][] grid, int m, int n) {
            int[][] min = new int[m][n];
            min[0][0] = grid[0][0];
            
            for ( int i = 1; i < m; i++) {
                min[i][0] = min[i-1][0] + grid[i][0];
            }
            
            for ( int i = 1; i < n; i++) {
                min[0][i] = min[0][i-1] + grid[0][i];
            }
            
            for ( int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    min[i][j] = (min[i-1][j] < min[i][j-1] ? min[i-1][j] : min[i][j-1]) + grid[i][j];
                }
            }
            
            return min[m-1][n-1];
        }
        
        
        public int minPathSum3(int[][] grid) {
            // Start typing your Java solution below
            // DO NOT write main() function
            
            return minPathSum3(grid, grid.length, grid[0].length);
            
        }
        
        public int minPathSum3(int[][] grid, int m, int n) {
            int[][] min = new int[1][n];
            min[0][0] = grid[0][0];
            
            for (int i = 1; i < n; i++) {
            	min[0][i] = min[0][i-1] + grid[0][i];
            }
            
            for (int j = 1; j < m; j++) {
            	min[0][0] += grid[j][0];
            	
            	for ( int i = 1; i < n; i++) {
            		int value = grid[j][i];
            		value += min[0][i] < min[0][i - 1] ? min[0][i] : min[0][i - 1];
            		min[0][i] = value;
            	}
            }        

            return min[0][n-1];
        }
    
    public static void main(String[] args) {
    	int[][] grid = {{1,2,5},{3,2,1}};
    	Solution sol = new Solution();
    	System.out.println(sol.minPathSum2(grid));
    }
      
}