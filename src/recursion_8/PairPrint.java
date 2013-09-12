package recursion_8;

public class PairPrint {
	
	public static void printPair(int l, int r, char[] str, int count) {
		if (l < 0 || r < l ) 
			return;
		if (l == 0 && r == 0)
			System.out.println(str);
		else {
			if (l > 0) {
				str[count] = '(';
				printPair(l - 1, r , str, count + 1);
			}
			if (r > l) {
				str[count] = ')';
				printPair(l, r - 1, str, count + 1);
			}
		}
	}
	
		public static void printPair(int l, int r, char[] str) {
			printPair(l , r , str , 0);
		}
		
		public static void printPair(int count) {
			char[] str = new char[count*2];
			printPair(count, count, str);
		}

	
	public static void main(String[] args) {
		int i = 3;
		printPair(3);
	}

}
