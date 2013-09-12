package plusone;

public class Solution {
//    public static int[] plusOne(int[] digits) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int quan  = 1;
//        quan =  (int) (digits.length == 1 ? 1 : Math.pow(10,digits.length - 1));
//        int original = quan;
//        long sum = 0;
//        for ( int i = 0 ; i < digits.length ; i++) {
//            sum += digits[i] * quan;
//            quan /= 10;
//        }
//        
//        sum +=1;
//        int size = digits.length;
//        if (sum / original >10) {
//            size += 1;
//            original *= 10;
//        }
//        
//        int[] result = new int[size];
//        for (int i = 0; i < size; i ++) {
//            result[i] = (int) (sum/original);
//            sum -= result[i] * original;
//            original /= 10;
//        }
//        
//        return result;    
//    }
	
	 public int[] plusOne(int[] digits) {
	        int carry_on = 1;
	        int size = digits.length;
	        
	        for ( int i = 0 ; i < digits.length; i ++ ) {
	            carry_on = cal(digits[digits.length - i - 1 ] , carry_on);
	            if (carry_on == 1 && i == digits.length -1)
	                size += 1;
	        }
	        
	        int[] result = new int[size];
	        carry_on = 1;
	        for ( int i = 0 ; i < size; i ++ ) {
	        	if (i != size - 1) {
		            result[size - i - 1]= jisuan(digits[digits.length - i - 1 ] , carry_on);
		            carry_on = cal(digits[digits.length - i - 1 ] , carry_on);
	        	} //else {
	        	//	result[size - i - 1] = carry_on;
	        	//}
             else {
         		if ( size - digits.length == 1)
	        			result[0] = carry_on;
	        		else
	        			result[0] = jisuan(digits[digits.length - i - 1 ] , carry_on);
	        	}
	        }        
	        return result;
	    }
	    
	    private int cal (int a, int b) {
	        return (a+b >=10) ? 1: 0;
	    }
	    
	    private int jisuan (int a, int b) {
	        return (a+b) % 10;
	    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] sum = {9,8,7,6,5,4,3,2,1,0};
    	int[] result = new Solution().plusOne(sum);
    }
}