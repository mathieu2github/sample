package findFirstmissingPositive;

public class Solutionnn {
    public int firstMissingPositive(int[] A) {
		if (A == null) return 1;
		int shift = separate(A);
		return firstMissingPositive(A,shift);
	}
	
	
	private int firstMissingPositive(int[] arr, int shift) {
		int i = shift;
		for (;i < arr.length;i++) {
			if (abs(arr[i]) - 1 < arr.length - shift && arr[abs(arr[i]) - 1+shift] > 0)
				arr[abs(arr[i]) - 1 + shift] = - arr[abs(arr[i]) - 1 + shift];			
		}
		
		for (i = shift; i< arr.length;i++) 
			if (arr[i] > 0)
				return i-shift+1;
		return arr.length - shift+1;
	}
	
	private int separate(int[] arr) {
		int i = 0;
		int j = 0;
		for (;i< arr.length;i++) {
			if (arr[i] <=0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j++] = temp;				
			}
		}
		return j;
	}
	
	private int abs(int n) {
		return n < 0 ? -n : n;
	}
}