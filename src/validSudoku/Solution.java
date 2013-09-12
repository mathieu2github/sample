package validSudoku;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();	
		sol.validSudoku(args[0]);
	}
	
	private int toConv(String s) {
		return Integer.parseInt(s);
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
		
	private int[][] takeSudoku(String s) {
		try{
			  FileInputStream fstream = new FileInputStream(s);
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));

			  String line1 = br.readLine();
			  String[] l1 = line1.split(",");
			  int size = l1.length;
			  
			  int[][] grid = new int[size][size];
			  
			  for (int i = 0; i < size; i++) {
				  grid[0][i] = toConv(l1[i]);
			  }
			  
			  for (int i = 1; i < size; i++) {
				  String line2 = br.readLine();
				  String[] l2 = line2.split(",");
				  for (int j = 0; j < size; j++) {
					  grid[i][j] = toConv(l2[j]);
				  }
			  }
			  
		  //Close the input stream
		  in.close();
		  return grid;
		  }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
		return null;
		
	}
	
	public boolean validSudoku(String s) {
		int[][] grid = takeSudoku(s);
		printOut(grid); 
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] < 1 || grid[i][j] > grid.length) {
					System.out.println("the sudoku is NOT valid due to input errors and not even come to checking stage");
					return false;
				}
			}
		}
		
		if (checkRow(grid) && checkColumn(grid)&&checkBlocks(grid)){
			System.out.println("the sudoku is valid");
			return true;
		}
		System.out.println("the sudoku is NOT valid");
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
					System.out.println("Row " + i + " th failed the rule!" );
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
					System.out.println("Column " + i + " th failed the rule!" );
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
				System.out.println("block begins at [" + i + "] [" + j + "] failed the rule!" );
				return false;
			}
		}
		return true;	
	}

}
