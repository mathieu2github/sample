package linkedlist;

public class DNF {
	 public void sortColors(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int p = 0;
	        int q = A.length - 1;
	        
	        for (int i = 0; i < A.length;) {
	            if (A[i] == 0) {
	                int temp = A[p];
	                A[p] = A[i];
	                A[i] = temp;
	                p++;
	                i++;
	            } else if (A[i] == 1) {
	                i++;
	            } else if (A[i] == 2 ){
	                int temp = A[q];
	                A[q] = A[i];
	                A[i] = temp;
	                q--;                
	            } else {}
	        }
	    }
	
	public static void main(String[] args) {
		int[] arr = {0,2,1,1,2,0,0,2,1,0,2,0,1,2,1,2};
		
		int arr_length = arr.length;
		int p = 0;
		int q = arr_length - 1;
		
		for (int i = 0; i <=q;) {
			if (arr[i] == 0) {
				swap(arr, i,p);
				i++;p++;
				
			} else if (arr[i] == 2) {
				swap(arr, i ,q);
				q--;
			} else {
				i++;	
			}
		}
		
        System.out.println("Printing the sorted array:");
        for(int i = 0; i < arr_length; i++){
                System.out.print(" "+arr[i]);
        }
		
	}
	
	private static void swap (int[] arr, int p, int q) {
		int temp = arr[q];
		arr[q] = arr[p];
		arr[p] = temp;
		
	}

}
