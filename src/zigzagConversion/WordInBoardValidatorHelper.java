package zigzagConversion;
import java.util.Arrays;

public class WordInBoardValidatorHelper{
	
	public static void main(String[] args) {
		WordInBoardValidatorHelper helper = new WordInBoardValidatorHelper();
		char[][] table = {
				{'G','O','T','P'},
				 {'C','I','E','G'},
				 {'N','N','S','D'},
				 {'F','A','R','W'}
				 };
		char[] targer = "endings".toUpperCase().toCharArray();
		System.out.println(helper.find(table, targer));
	}
	
	
	public boolean find(char[][] matrix, char[] target) {
		//Walk through each node
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length ; j++) {
				//If we find the first match
				if (matrix[j][i] == target[0]) {
					//Mask is used to represent each node we have visited
					boolean[][] mask = new boolean[matrix.length][matrix[0].length];
					//set the visited node to true
					mask[j][i] = true;
					
					int[] counts = new int[26];
					for (int k = 0; k < counts.length; k++) {
						counts[k] = 0;
					}
					
					for (char temp : target) {
						int index = (char) (Character.toUpperCase(temp) - 'A');
						counts[index] = counts[index] + 1;
					}
					int indexOne = Character.toUpperCase(target[0]) - 'A';
					counts[indexOne] = counts[indexOne] - 1;
					//if it is a single word, return true directly
					if (target.length == 1) return true;
					//find the next word
					if (find(matrix, j, i, counts, target.length - 1, mask)) {
						return true;
					}
				}
			}
		}
		return false;		
	}
	
	//Recursive call
	public boolean find(char[][] matrix, int y, int x, int[] counts, int totalCounts, boolean[][] mask) {
		//[3][0]  j == 3, i == 0, y ==3, x ==0
		
		/*			   [2][-1]  [2][0] [2][1]
		 *             [3][-1]  [3][0] [3][1]
		 *             [4][-1]  [4][0] [4][1]
		 *             
		 *             
		 *             
		 */  		
		int xLeft = x - 1;
		int xRight = x + 1;
		int yUp = y - 1;
		int yDown = y + 1;

		
		//Check if this node is valid one or unvisited and match the target
		//Left
		if (evaluate(matrix, xLeft, y, counts, totalCounts, mask,y,x)) {
			return true;
		}
		
		//Up
		if (evaluate(matrix, x, yUp, counts, totalCounts, mask,y,x)) {
			return true;
		}
		
		
		//Right
		if (evaluate(matrix, xRight, y, counts, totalCounts, mask,y,x)) {
			return true;
		}
		
		//Down
		if (evaluate(matrix, x, yDown, counts, totalCounts, mask,y,x)) {
			return true;
		}
		
		//LeftUp
		if (evaluate(matrix, xLeft, yUp, counts, totalCounts, mask,y,x)) {
			return true;
		}
		
		
		//RightUp
		if (evaluate(matrix, xRight, yUp, counts, totalCounts, mask,y,x)) {
			return true;
		}
		
		//LeftDown
		if (evaluate(matrix, xLeft, yDown, counts, totalCounts, mask,y,x)) {
			return true;
		}
		
		//RightDown
		if (evaluate(matrix, xRight, yDown, counts, totalCounts, mask,y,x)) {
			return true;
		}	
		return false;
		
	}

	//Check if this node is valid one or unvisited and the node value equals to the target char
	public boolean evaluate(char[][] matrix, int x, int y, int[] counts, int totalCounts, boolean[][] mask,int y1, int x1) {
		if (x < 0 || x >= matrix[0].length || y < 0 || y >= matrix.length) {
			return false;
		}
		if (mask[y][x]) {
			return false;
		}
		
		if (counts[matrix[y][x] - 'A'] <= 0) return false;
		
		if (totalCounts == 1) return true;
		
		boolean[][] childMask = copyMask(mask);
		childMask[y][x] = true;
		
		int[] childCounts = Arrays.copyOf(counts, counts.length);
		int index = matrix[y][x] - 'A';
		childCounts[index] = childCounts[index] - 1;
		
		return find(matrix, y, x, childCounts, totalCounts -1, childMask) || find(matrix, y1, x1, childCounts, totalCounts -1, childMask);
	}

	public boolean[][] copyMask(boolean[][] mask) {
		boolean[][] childMask = new boolean[mask.length][mask[0].length];
		for (int k = 0; k < mask.length; k++) {
			childMask[k] = Arrays.copyOf(mask[k], mask[0].length);
		}
		return childMask;
	}

}