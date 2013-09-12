package jumpGame;

public class Solution { //wrong answer
	

//    public boolean canJump(int[] A) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//       // if (A.length == 1)return true;
//        return canJump(A,0);
//    }
//    
//    public boolean canJump(int[] A,int n) {
//        if (A[n] >= A.length - 1 - n ){
//            return true;
//        } else {
//            if (A[n] !=0)
//            	return canJump(A, n + A[n]);
//            return false;
//        }
//    }
	
	int[]save;
	
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// if (A.length == 1)return true;
		
		int[] save = new int[A.length];
		for (int i = 0; i < A.length; i++) {
	        save[i] = -1;
		}
		return canJump(A,0,save);
	}	    
	    
	public boolean canJump(int[] A,int n,int[] save) {
		if( n <= A.length - 1&& save[n] == -1) {
			if (A[n] >= A.length - 1 - n ){
				save[n] = 1;
				return true;
			} else {
				if (A[n] !=0) {
					for ( int i = 1; i <= A[n]; i++) {
						if (!canJump(A,n+i,save))
							continue;
						save[n] = 1;
						return true;
					}
				}
				save[n] = 0;
				return false;
			}
		}
		        
		if (n <= A.length - 1&& save[n] == 0)
			return false;
		if (n <= A.length - 1&& save[n] == 1)
			return true;
		return false;		        
	}
	
	//best answer is below. DP
	public boolean canJump(int[] A, int size) {
		int i = 0;
		int j = 0;
		
		while (i<=j) {
			j = A[i] + i > j ? A[i] + i:j;
			if (A[j] + j >= size - 1)
				
				//if (j >= size-1) is better;
				return true;
			i++;
		}
		return false;
	}

	
	public boolean judgeJumpable(int[] a) {
		int i = 0, j = 0;
		
		while ( i <= j) {
			j = a[i] + i > j ? a[i] + i : j;
			if (a[j] + j > a.length - 1)//j maybe bigger than size -1,overflow happens
				return true;
			i++;
		}
		return false;
	}
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] A = {1,2,2,6,3,6,1,8,9,4,7,6,5,6,8,2,6,1,3,6,6,6,3,2,4,9,4,5,9,8,2,2,1,6,1,6,2,2,6,1,8,6,8,3,2,8,5,8,0,1,4,8,7,9,0,3,9,4,8,0,2,2,5,5,8,6,3,1,0,2,4,9,8,4,4,2,3,2,2,5,5,9,3,2,8,5,8,9,1,6,2,5,9,9,3,9,7,6,0,7,8,7,8,8,3,5,0};
    	System.out.println(sol.canJump(A));
    }
 

}
