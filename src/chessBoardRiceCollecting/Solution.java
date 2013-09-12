package chessBoardRiceCollecting;

class Solution { 
	
	public int rice_chessboard3(int[][] A) {
		int rows=A.length;
		int cols=A[0].length;
		
		int[][] max = new int[rows][cols];
		max[0][0] = A[0][0];
		for(int i=1;i<rows;i++)
			max[i][0] = A[i][0]+max[i-1][0];
		for(int i=1;i<cols;i++)
			max[0][i] = A[0][i]+max[0][i-1];	
		for(int row=1;row<rows;row++)
			for(int col=1;col<cols;col++)
			{
				max[row][col] = A[row][col];
				max[row][col] +=max[row-1][col]>max[row][col-1]?max[row-1][col]:max[row][col-1];			
			}	
		return max[rows-1][cols-1];
	}// construct a matrix and return the max[rows-1][cols-1];
	
	public int rice_chessboard2(int[][] A)
	{
		int rows=A.length;
		int cols=A[0].length;
		
		//int[][] max = new int[rows][cols];
		int[] maxInRow, maxInCol;
		int rowCount=0, colCount=0;
		
		maxInRow = new int[cols];
		maxInCol = new int[rows];
		maxInRow[0]=A[0][0];
		maxInCol[0]=A[0][0];
		
		for(int i=1;i<rows;i++)
			maxInCol[i] = A[i][0]+maxInCol[i-1];
		for(int i=1;i<cols;i++)
			maxInRow[i] = A[0][i]+maxInRow[i-1];
		
		colCount++; rowCount++;
		while(rowCount<rows)
		{
			maxInRow[0] = maxInCol[rowCount];
			for(int i=1;i<cols;i++)
			{
				int value=A[rowCount][i];
				value += maxInRow[i]>maxInRow[i-1]?maxInRow[i]:maxInRow[i-1];
				maxInRow[i] = value;
			}
			rowCount++;
		}	
		return maxInRow[cols-1];
	}

	public int rice_chessboard(int[][] A) {
		
		if (A.length <= 0 || A[0].length <= 0) {
			return 0;
		}
		
		return getMax(A, 0, 0);
		
	}
	
	public int getMax(int[][] A, int x, int y) {
		int maxY = A.length;
		int maxX = A[0].length;
		
		
		if (x == maxX - 1 && y == maxY - 1) {
			return A[y][x];
		}
		
		if (x == maxX - 1) {
			return A[y][x] + getMax(A, x, y + 1);
		}
		
		if (y == maxY - 1) {
			return A[y][x] + getMax(A, x + 1, y);
		}
		
		return getMax(A, x + 1, y) + A[y][x] > getMax(A, x, y + 1) + A[y][x]?
			   getMax(A, x + 1, y) + A[y][x] : getMax(A, x, y + 1) + A[y][x];
		
	}

	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] sample = {{2, 2, 3, 0}, {0, 3, 1, 1}, {1, 2, 2, 1}, {4, 1, 2, 2}};
		//int[][] sample = {{1, 1, 1, 1}, {100, 1, 1, 1}, {100, 1, 9000, 1}, {100, 100, 100, 1}};
		
		System.out.println(sol.rice_chessboard(sample));
		System.out.println(sol.rice_chessboard2(sample));
		System.out.println(sol.rice_chessboard3(sample));
		
	}
	

}
