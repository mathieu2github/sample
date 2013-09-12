package spiralMatrix2;

import java.util.ArrayList;

public class Solution {
public int[][] generateMatrix(int n) {
	if (n == 0) return new int[0][0];
	if (n == 1) {
		int[][] res = {{1}};
		return res;
	}
	int[][] matrix = new int[n][n];

    int limit = (n - 1)/2 +1;
    return generateMatrix(matrix,0,0,n,n,limit,1);
}

public int[][] generateMatrix(int[][] matrix, int n, int m,int p, int q,int limit,int value) {
	if (n == limit) {
		if (p%2 == 0)
			return matrix;
		matrix[n-1][m-1] = value;
		return matrix;
	}

	for (int i = m; i < q - 1 - n; i++) {
		matrix[n][i] = value++;
	}
	
	for (int i = m; i < p - 1 - n; i++) {
		matrix[i][q-1-n]=value++;
	}
	
	for (int i = q - m - 1; i > n; i--) {
		matrix[p-1-n][i]=value++;
    }
	
	for (int i = p - m - 1; i > n; i--) {
		matrix[i][n]=value++;
    }
	
	
	return generateMatrix(matrix,n+1,m+1,p,q,limit,value);
		
}

    
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
		sol.printMatrix(sol.generateMatrix(12));
	}

}
