package findWordInTwoDimentionArray;

import java.util.Arrays;

public class Main{
	
	
	public boolean find(char[][] matrix, char[] target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[j][i] == target[0]) {
					boolean[][] mask = new boolean[matrix[0].length][matrix.length];
					mask[j][i] = true;
					if (target.length == 1) return true;
					if (find(matrix, j, i, target, 1, mask)) {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	public boolean find(char[][] matrix, int x, int y, char[] target, int indexOfTarget, boolean[][] mask) {
		
		int xMax = matrix[0].length;
		int yMax = matrix.length;
		int xLeft = x - 1;
		int xRight = x + 1;
		int yUp = y - 1;
		int yDown = y + 1;

		boolean[][] childMask = copyMask(mask, xMax, yMax);
		
		if (evaluate(matrix, xLeft, yUp, target, indexOfTarget, childMask)) {
			if (indexOfTarget == target.length - 1) {
				return true;
			}
			if (find(matrix, xLeft, yUp, target, indexOfTarget, childMask)) {
				return true;
			}
		}
		
		childMask = copyMask(mask, xMax, yMax);
		
		if (evaluate(matrix, xLeft, yDown, target, indexOfTarget, childMask)) {
			if (indexOfTarget == target.length - 1) {
				return true;
			}
			if (find(matrix, xLeft, yDown, target, indexOfTarget, childMask)) {
				return true;
			}
		}
		
		childMask = copyMask(mask, xMax, yMax);
		
		if (evaluate(matrix, xRight, yUp, target, indexOfTarget, childMask)) {
			if (indexOfTarget == target.length - 1) {
				return true;
			}
			if (find(matrix, xRight, yUp, target, indexOfTarget, childMask)) {
				return true;
			}
		}
		
		childMask = copyMask(mask, xMax, yMax);
		
		if (evaluate(matrix, xRight, yDown, target, indexOfTarget, childMask)) {
			if (indexOfTarget == target.length - 1) {
				return true;
			}
			if (find(matrix, xRight, yDown, target, indexOfTarget, childMask)) {
				return true;
			}
		}
		
		return false;
		
	}

	
	public boolean evaluate(char[][] matrix, int x, int y, char[] target, int indexOfTarget, boolean[][] mask) {
		if (x < 0 || x >= matrix[0].length || y < 0 || y >= matrix.length) {
			return false;
		}
		if ((! mask[y][x])) {
			return false;
		}
		
		mask[y][x] = true;
		
		if (target[indexOfTarget] == matrix[y][x]) {
			return true;
		}
		return false;
	}

	public boolean[][] copyMask(boolean[][] mask, int xMax, int yMax) {
		boolean[][] childMask = new boolean[yMax][xMax];
		for (int k = 0; k < mask.length; k++) {
			childMask[k] = Arrays.copyOf(mask[k], xMax);
		}
		return childMask;
	}

}
