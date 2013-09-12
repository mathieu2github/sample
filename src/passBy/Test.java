package passBy;

public class Test {
	
	
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public void change(int[] a, int n, int m) {
		int temp = a[n];
		a[n] = a[m];
		a[m] = temp;
	}
	
	
	
	public static void main(String[] args) {
		int[] a = {2,3,4,5,1};
		Test t = new Test();
		t.print(a);
		t.change(a, 0, 4);
		System.out.println();
		t.print(a);
		
		
	}
	
	
	

}
