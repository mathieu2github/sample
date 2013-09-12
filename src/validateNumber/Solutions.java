package validateNumber;

public class Solutions {
	public boolean isNumber(String s) {
		char[] nums = s.toCharArray();
		
		boolean pointOver = false; //sawPoint
		//boolean signOver = false; // i would name it as sawSign
//		boolean hasNumber = false; // sawNum
		int i = 0;
		
		for ( ;i<nums.length;i++) {
			//i should not ++, otherwise i+2 each time
			//if (nums[i] ==' ') i++; 
			if (nums[i] != ' ')
				break; //Yang
			
		}
		
		if (nums[i] == '+' || nums[i] == '-') {
			i++;
		}
		
		//You did not use signOver or pointOver
		
		//so far i did not see hasNumber is useful, since +.9 is valid in your case. 
				
		//Yang
		
		for (; i < nums.length; i++) {
			if (nums[i] == '.') {
				if (pointOver) return false;
				pointOver = true;
			}
			
			else if (nums[i] >='0' && nums[i] <='9') {
				continue;
			} else
				return false;
		}
			
//		for (; i < nums.length; i++) {
//			if (nums[i] >='0' && nums[i] <='9') {
//				hasNumber = true;
//				continue;
//			}
//			else
//				break;
//
//		}
//			
//		if ( i < nums.length&&nums[i] == '.') {
//			pointOver = true;
//			i++;
//		} else {
//			return false;
//		}
//		
//		for (; i < nums.length; i++) {
//			if (nums[i] >='0' && nums[i] <='9')
//				continue;
//			else
//				return false;
//
//		}	
		return true;
	}
	
	public static void main(String[] args) {
		Solutions sol = new Solutions();
		String s = "12.3";
		System.out.println(sol.isNumber(s));
	}
}
