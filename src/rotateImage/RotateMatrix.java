package rotateImage;

public class RotateMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] original = {{1,2,3,4,5},
							{6,7,8,9,10},
							{11,12,13,14,15},
							{16,17,18,19,20},
							{21,22,23,24,25,26}
							};
		int n=5;
		rotateMatrix(original, n, 1);  
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				System.out.print(original[i][j] +" ");
				if(j==n-1)
					System.out.println("");
			}

	}
	
	public static void rotateMatrix(int[][] original, int n, int loop)
	{
		if(n-loop>1){
		
		int sideLength = n+1-2*loop;
		int length = 4*sideLength;
		int[] array = new int[length];
		//store data
		for(int i=0;i<sideLength;i++)
		{
			array[i] = original[loop-1][i+loop-1];
		}
		for(int i=0;i<sideLength;i++)
		{
			array[sideLength+i] = original[i+loop-1][n-loop];
		}
		for(int i=0;i<sideLength;i++)
		{
			array[2*sideLength+i] = original[n-loop][n-loop-i];
		}
		for(int i=0;i<sideLength;i++)
		{
			array[3*sideLength+i] = original[n-loop-i][loop-1];
		}
		
		for(int i=0;i<length;i++)
			System.out.print(array[i]+" ");
		System.out.println("");
		//write data
		for(int i=0;i<sideLength;i++)
		{
			original[loop-1][i+loop-1]=array[3*sideLength+i];
		}
		for(int i=0;i<sideLength;i++)
		{
			original[i+loop-1][n-loop]=array[i];
		}
		for(int i=0;i<sideLength;i++)
		{
			original[n-loop][n-loop-i] =array[sideLength+i];
		}
		for(int i=0;i<sideLength;i++)
		{
			original[n-loop-i][loop-1] = array[2*sideLength+i];
		}
		
		rotateMatrix(original, n, loop+1);
		}
		
	}

}
