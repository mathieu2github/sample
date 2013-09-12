package validSudoku;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		char[][] board = {{'.','.','.','.','.','.','.','.','.'},//1
				{'.','.','.','.','.','.','.','.','.'},//2
				{'.','.','.','.','.','.','.','.','.'},//3
				{'.','.','.','.','.','.','.','.','.'},//4
				{'.','.','.','.','.','.','.','.','.'},//5
				{'.','.','.','.','.','.','.','.','.'},//6
				{'.','.','.','.','.','.','.','.','.'},//7
				{'.','.','.','.','.','.','.','.','.'},//8
				{'.','.','.','.','.','.','.','.','.'},//9
				};
		sol.isValidSudoku(board);
		
		
	}
	
	public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return validSudoku(board);
    }
	
	private int toConv(String s) {
		try {
		return Integer.parseInt(s);
		} catch (java.lang.NumberFormatException e) {
			return -1;
		}
	}
	
	private void printOut(int[][] grid) {
		int len = grid.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
		
	private int[][] takeSudoku(char[][] board) {
		int[][] grid = new int[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++)
				grid[i][j] = toConv(board[i][j] + "");
		}
		return grid;
	}
	
	public boolean validSudoku(char[][] board) {
		int[][] grid = takeSudoku(board);
		
//		printOut(grid); 
		
//		for (int i = 0; i < board.length; i ++) {
//			for (int j = 0; j < board.length; j ++) {
//				if (grid[i][j] == -1) {
//					return false;
//				}
//			}
//		}
		
		if (checkRow(grid) && checkColumn(grid)&&checkBlocks(grid)){
			return true;
		}
		return false;
	}
	
	private boolean checkRow(int[][] grid) {
		int len = grid.length;
		
		for (int i = 0; i < len; i++) {
			boolean[] arr = new boolean[len];
			for (int j = 0; j < len; j++) {
					arr[grid[i][j]-1] = true;
			}
			for (boolean ele : arr) {
				if (!ele) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean checkColumn(int[][] grid) {
		int len = grid.length;
		
		for (int i = 0; i < len; i++) {
			boolean[] arr = new boolean[len];
			for (int j = 0; j < len; j++) {
				arr[grid[j][i]-1] = true;
			}
			for (boolean ele : arr) {
				if (!ele) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean checkBlocks(int[][] grid) {
		int size = grid.length;
		int len = (int) Math.sqrt(size);
		for (int i = 0; i < size;) {
			for (int j = 0; j < size;) {
				if (!checkBlock(grid,i,j,len)) 
					return false;
				j += len;
			}
			i += len;
		}
		return true;
	}
	
	private boolean checkBlock(int[][] grid, int i, int j, int len) {
		boolean[] arr = new boolean[len * len];
		for (int row = 0; row < len; row ++) {
			for (int col = 0; col < len; col ++) {
				arr[grid[i+row][j+col]-1] = true;
			}
		}
		for (boolean ele : arr) {
			if (!ele) {
				return false;
			}
		}
		return true;	
	}

}
