package findFirstmissingPositive;

public class Solutionn {
	public int firstMissingPositive(int[] A) {
		if (A == null) return 1;
		//int shift = separate(A);
		
		int[] result = separate(A);
		return findFirstMissingPositive(result);
	}
	
	
	private int firstMissingPositive(int[] arr, int shift) {
		int i = shift;
		for (;i < arr.length;i++) {
			if (abs(arr[i]) - 1 < arr.length - shift && arr[abs(arr[i] - 1)+shift] > 0)
				arr[abs(arr[i] - 1)+shift] = - arr[abs(arr[i] - 1)+shift];			
		}
		
		for (i = shift; i< arr.length;i++) 
			if (arr[i] > 0)
				return i-shift+1;
		return arr.length - shift+1;
	}
	
	private int findFirstMissingPositive(int[] arr) {
		int i = 0;
		for (;i < arr.length;i++) {
			if (abs(arr[i]) - 1 < arr.length && arr[abs(arr[i]) - 1] > 0) {
				int local = arr[i];
				int local2 = abs(arr[i]);
				int local3 = abs(arr[i]) - 1;
				arr[abs(arr[i]) - 1] = - arr[abs(arr[i]) - 1];	
			}
						
		}
		
		for (i = 0; i< arr.length;i++) 
			if (arr[i] > 0)
				return i+1;
		return arr.length +1;
	}
	
	private int[] separate(int[] arr) {
		int i = 0;
		int j = 0;
		for (;i< arr.length;i++) {
			if (arr[i] <=0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j++] = temp;				
			}
		}
		int[] result = new int[arr.length - j];
		for (int m = 0; m< result.length;m++,j++) {
			result[m] = arr[j];
		}
		
		return result;
	}
	
	private int abs(int n) {
		return n < 0 ? -n : n;
	}
	
	public static void main(String[] args) {
		Solutionn sol = new Solutionn();
		int[] sample = {1,2,0};
//		int[] sample = null;
		int missing = sol.firstMissingPositive(sample);
		System.out.println(missing);
	}
}
