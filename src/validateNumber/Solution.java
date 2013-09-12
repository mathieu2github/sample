package validateNumber;


public class Solution {
	
	public boolean isNumber(String s) {
        if (s == null) return false;
        if (s.length() == 0) return false;
        if (s.charAt(0) == ' ') return isNumber(s.substring(1).trim());
		if (isNegative(s.charAt(0)))
			return isNumber(s.substring(1),true);
		return isNumber(s,true);	
	}
	
	public boolean isPosNeg(String s) {
		return isPos(s) || isNeg(s);
	}
	public boolean isPos(String s) {
        if (s == null) return false;
        if (s.length() == 0) return false;
        if (s.charAt(0) == ' ') return isPos(s.substring(1).trim());
        char[] nums = s.toCharArray();
		for (int i = 0; i<nums.length;i++) {
			if (!isDigit(nums[i]))
				return false;
		}
		return true;
	}
	
	public boolean isNeg(String s) {
        if (s == null) return false;
        if (s.length() == 0) return false;
        if (s.charAt(0) == ' ') return isPos(s.substring(1).trim());
		return isNegative(s.charAt(0)) && isPos(s.substring(1).trim());

	}
	
	public boolean isNumber(String s, boolean flag) {
		if (!flag) {
	        if (s == null) return false;
	        if (s.length() == 0) return false;
	        if (s.charAt(0) == ' ') return isNumber(s.substring(1).trim(),false);
			return isPos(s.trim());
		}
		else {
	        if (s == null) return false;
	        if (s.length() == 0) return false;
	        if (s.charAt(0) == ' ') return isNumber(s.substring(1).trim(),true);
			char[] nums = s.toCharArray();
			for (int i = 0; i < nums.length; i++) {
				if(isE(nums[i])) {
					return isPos(s.substring(0,i).trim()) && isPosNeg(s.substring(i+1).trim());
				} else if (isPoint(nums[i])) {
					return isPos(s.substring(0,i).trim()) || isPos(s.substring(i+1).trim());
				} else if (isDigit(nums[i]))
					continue;
				else
					return false;
			}
		}
		return true;		
	}
	
	public boolean isDigit(char c) {
		return c >= '0' && c <='9';
	}
	
	public boolean isPoint(char c) {
		return c == '.';
	}
	
	public boolean isE(char c) {
		return c == 'e'|| c == 'E';
	}
	
	public boolean isNegative(char c) {
		return c == '-'|| c == '+';
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String sample = "   0.1  " +
				"";
		
		System.out.println(sol.isNumber(sample));
	}

}
