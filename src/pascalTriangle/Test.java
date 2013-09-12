package pascalTriangle;

import java.util.*;

public class Test {

	public ArrayList<ArrayList<Integer>> generate(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n <= 0) {
//			return result;
		} else if ( n == 1) {
			ArrayList<Integer> first = new ArrayList<Integer>();
			first.add(1);
			result.add(first);
		} else if ( n == 2) {
			ArrayList<Integer> first = new ArrayList<Integer>();
			first.add(1);
			result.add(first);
			ArrayList<Integer> second = new ArrayList<Integer>();
			second.add(1);
			second.add(1);
			result.add(second);
		} else {
			result = generate(2);
			ArrayList<Integer> last = result.get(result.size() - 1);
			for ( int i = 0; i < n - 2; i++) {
				ArrayList<Integer> local = new ArrayList<Integer>();
				local.add(1);
				for (int j = 0; j < last.size() - 1; j++) {
					local.add(last.get(j) + last.get(j+1));
				}
				local.add(1);
				result.add(local);
				last = local;
			}
		}
		
		return result;		
	}
	
	public void printPascal(ArrayList<ArrayList<Integer>> sample) {
		for (ArrayList<Integer> ele : sample) {
			for (Integer num : ele) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.printPascal(t.generate(10));
	}
}
