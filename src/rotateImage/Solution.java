package rotateImage;

public class Solution {
	
	public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		int m = matrix.length / 2;
		rotate(matrix, m, 0);
        
    }
	
	public void rotate(int[][] matrix, int limit, int times) {
		if (limit == times) return;
		int row = matrix.length;
		int m = row - times - 1;
		for (int i = times; i< m;i++) {
			rotatefour(matrix,times,i);
		}
		
		times++;
		rotate(matrix,limit,times);

		
	}

	
	public void rotatefour(int[][] matrix, int n, int m) {
		int row = matrix.length;
		int temp = matrix[row - m- 1][n];
		matrix[row - m - 1][n] = matrix[row - 1 - n][row - m - 1];
		matrix[row - 1 - n][row - m - 1] = matrix[m][row - 1 - n];
		matrix[m][row - 1 - n] = matrix[n][m];
		matrix[n][m] = temp;
		
		matrix[n][m]= temp;
		//matrix[m][row - 1 - n] = matrix[n][m];
		
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
		System.out.println();
	}
    
    public void printMatrix(char[][] matrix) {
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
		System.out.println();
	}
    
//	public void printMatrix(int[][] matrix) {
//	int n = matrix.length;
//	
//	for (int i = 0; i < n; i++) {
//		for (int j = 0; j < n; j++) {
//			System.out.print(matrix[i][j] + " ");
//			if (j == n -1)
//				System.out.println();
//		}
//	}
//}
    
        public void rotate2(int[][] matrix) {
            // Start typing your Java solution below
            // DO NOT write main() function
            
            int times = matrix.length/2;
            
            for (int i = 0; i< times;i++) {
                rotate2(matrix,i);
            }
        }
        
        public void rotate2(int[][] matrix, int times) {
            int len = matrix.length;
            for(int i = 0; i < len- 1 - times*2;i++) {
                int temp = matrix[times][times + i];
                matrix[times][times + i] =matrix[times + i][len - 1 - times];
                matrix[times + i][len - 1 - times] = matrix[len - 1 - times][len - 1 - times - i];
                matrix[len - 1 - times][len - 1 - times - i] = matrix[len - 1 - times - i][times];
                matrix[len - 1 - times - i][times] = temp;                
            }
        }
        
        public void rotate2(char[][] matrix) {
            // Start typing your Java solution below
            // DO NOT write main() function
            
            int times = matrix.length/2;
            
            for (int i = 0; i< times;i++) {
                rotate2(matrix,i);
            }
        }
        
        public void rotate2(char[][] matrix, int times) {
            int len = matrix.length;
            for(int i = 0; i < len- 1 - times*2;i++) {
                char temp = matrix[times][times + i];
                matrix[times][times + i] =matrix[times + i][len - 1 - times];
                matrix[times + i][len - 1 - times] = matrix[len - 1 - times][len - 1 - times - i];
                matrix[len - 1 - times][len - 1 - times - i] = matrix[len - 1 - times - i][times];
                matrix[len - 1 - times - i][times] = temp;                
            }
        }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] matrix = {{1, 2, 3, 4},
                		  {5, 6, 7, 8},
                		  {9, 10, 11, 12},
                		  {13, 14, 15, 16}};
		
		int[][]matrix2 = {{1,2,3},
						  {4,5,6},
						  {7,8,9}
						  };
		
		char[][] matrix3 = {{'*','*','*'},{'$','$','$'},{'*','*','*'}};
		sol.printMatrix(matrix);
		sol.rotate2(matrix);
		sol.printMatrix(matrix);
		sol.printMatrix(matrix2);
		sol.rotate2(matrix2);
		sol.printMatrix(matrix2);
		sol.printMatrix(matrix3);
		sol.rotate2(matrix3);
		sol.printMatrix(matrix3);
		
	}
	

}
