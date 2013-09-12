package spiralMatrix;

import java.io.*;
import java.util.ArrayList;

public class spiral_printing {
	
    public static void main (String[] args) throws IOException {
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    spiral_printing sol = new spiral_printing();
    while ((line = in.readLine()) != null) {
//    	System.out.println(line);
    	String[] lineArray = line.split(";");
        if (lineArray.length > 0) {
        	int n = Integer.parseInt(lineArray[0]);
        	int m = Integer.parseInt(lineArray[1]);
        	String[][] matrix = new String[n][m];
        	String[] elements = lineArray[2].split(" ");
        	for (int i = 0; i < n; i ++) {
        		for (int j = 0; j < m; j++) {
        			matrix[i][j] = elements[i * m +j];
        		}
        	}
    		
//    		sol.printMatrix(matrix);
    		ArrayList<String> res = sol.spiralOrder(matrix);
    		for ( String i : res) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
        }
    }
  }
    
    public ArrayList<String> spiralOrder(String[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function      
        if (matrix == null)return null;
        int n = matrix.length;
        if (n == 0) {
            return new ArrayList<String>();
        }
        int m = matrix[0].length;
        ArrayList<String> res = new ArrayList<String>();
        if (n == 1 && m == 1) {
            
            res.add(matrix[0][0]);
            return res;
        }
        return spiralOrder(matrix,res);
    }
    
    public ArrayList<String>spiralOrder(String[][] matrix,ArrayList<String>result) {
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
   
    
    
    public void printMatrix(String[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
					System.out.print("   " + matrix[i][j]);
				if (j == m -1)
					System.out.println();
			}
		}
	}
	
   
    
}