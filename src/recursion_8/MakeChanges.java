package recursion_8;

public class MakeChanges {
	
	public static int makeChanges (int n,int denom) {
		int next_denom = 0;
		switch (denom){
		case 25:
		next_denom = 10;
		break;
		case 10:
		next_denom = 5;
		break;
		case 5:
		next_denom = 1;
		break;
		case 1:
		return 1;
		}	
		int ways = 0;
		for (int i = 0; n - i * denom >= 0; i++) {
			ways += makeChanges (n - i * denom, next_denom);
		}		
		return ways;
 	}
	
	public static int makeChanges (int n) {
		return makeChanges(n, 25);
	}
	
	public static void main(String[] args) {
		int n = 110;
		System.out.println(makeChanges(n));
		
	}

}
