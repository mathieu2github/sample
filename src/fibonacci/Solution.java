package fibonacci;

import java.util.Date;

public class Solution {
	int[] memo;
	
	public int fib(int n) {
		if ( n <= 1)
			return n;
		return fib(n-1) + fib(n-2);
	}
	
	public void inti() {
		memo = new int[100];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = -1;
		}
	}
	
	public int fib(int n, boolean flag) {
		if (!flag)
			return fib(n);
		if (n < memo.length) {
			if (memo[n] == -1) {
				if ( n <= 1)
					memo[n] = n;
				else
					memo[n] = fib(n-1, true) + fib(n-2,true);
			}
			return memo[n];
		}
		else {
			return fib(n-1, true) + fib(n-2,true);
		}
	}
	
	
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.inti();
		System.out.println(new Date());
		int n = sol.fib(45,true);
		System.out.println(new Date());
		System.out.println(n);
	}

}
