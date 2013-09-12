package spiralMatrix;

import java.util.ArrayList;

public class Solution {
	
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function      
        if (matrix == null)return null;
        int n = matrix.length;
        if (n == 0) {
            return new ArrayList<Integer>();
        }
        int m = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n == 1 && m == 1) {
            
            res.add(matrix[0][0]);
            return res;
        }
        return spiralOrder(matrix,res);
    }
    
    public ArrayList<Integer>spiralOrder(int[][] matrix,ArrayList<Integer>result) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int i,j,k,r,c,l=0;
    	
    	
    	for (i = 0,c = col - 1,r = row - 1;c>=0 && r>=0;i++,r--,c--) {
    		for (k=i;k<=c;k++) {
    			if(l==row*col) break;
    			result.add(matrix[i][k]);
    			l++;
    		}
    		      	
        	for (k=i+1;k<=r;k++) {
        		if(l==row*col) break;
        		result.add(matrix[k][c]);
        		l++;
        	}
        	
        	for (k=c-1;k>=i;k--) {
        		if(l==row*col) break;
        		result.add(matrix[r][k]);
        		l++;
        	}
        	
        	for (k=r-1;k>i;k--) {
        		if(l==row*col) break;
        		result.add(matrix[k][i]);
        		l++;
        	}
        	
//        	if (l == col*row)
//        		break;
        	
    	}

    	
    	return result;
    		
    }
    
//    public ArrayList<Integer>spiralOrder(int[][] matrix, int n, int m,int p, int q,int limit) {
//    	if (n == limit) return null;
//    	ArrayList<Integer> result = new ArrayList<Integer>();
//
//    	for (int i = m; i < q - 1 - n; i++) {
//    		if (matrix[n][i]!=-1) {
//    			result.add(matrix[n][i]);
//    			matrix[n][i] = -1;
//    		}
//    		
//    		
//    	}
//    	
//    	for (int i = m; i < p - 1 - n; i++) {
//    		if (matrix[i][q-1-n]!=-1) {
//    			result.add(matrix[i][q-1-n]);
//    			matrix[i][q-1-n] = -1;
//    		}
//    		
//    	}
//    	
//    	for (int i = q - m - 1; i > n; i--) {
//    		if (matrix[p-1-n][i]!=-1) {
//        		result.add(matrix[p-1-n][i]);
//        		matrix[p-1-n][i] = -1;
//    		}
//    	}
//    	
//    	for (int i = p - m - 1; i > n; i--) {
//    		if (matrix[i][n]!=-1) {
//        		result.add(matrix[i][n]);
//        		matrix[i][n] = -1;
//    		}
//    	}
//    	
//    	if (spiralOrder(matrix, n + 1, m + 1,p,q,limit) != null)
//    		result.addAll(spiralOrder(matrix, n + 1, m + 1,p,q,limit));
//    	return result;
//    		
//    }
	
    public void printMatrix(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(matrix[i][j] < 10)
					System.out.print("   " + matrix[i][j]);
				else if (matrix[i][j] >= 10 && 100 > matrix[i][j])
					System.out.print("  " + matrix[i][j]);
				else
					System.out.print(" " + matrix[i][j]);
					
				if (j == m -1)
					System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] matrix = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
		
		int[][] matrix2 = {{1}};
		sol.printMatrix(matrix);
		ArrayList<Integer> res = sol.spiralOrder(matrix);
		for ( Integer i : res) {
			System.out.print(i + " ");
		}
	}
	

}
