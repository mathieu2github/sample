package multiplyStrings;

public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    if ( num1.length() == 1 && num1.charAt(0) == '0')
        return "0";
    
    if ( num2.length() == 1 && num2.charAt(0) == '0')
        return "0";
        

    
    int m = num1.length();
    int n = num2.length();
    
    char[] result = new char[n+m];
    
    for (int i = 0; i< n+m; i++) {
    	result[i] = '0';
    }
    
    for (int i = 0; i < m; i++) {
    	
    	for (int j = 0; j < n; j++) {
    		char a = num1.charAt(m - 1 - i);
    		char b = num2.charAt(n- 1- j);
    		writeResult(result, a, b, i + j);
    	}
    }
    
    
    	for (int i = 0; i < (n+m)/2;i++) {
    		char tmp = result[i];
    		result[i] = result[n+m -1-i];
    		result[n+m-i-1] = tmp;
    	}
    	
    	
    
    
    String res = new String(result);
    if (result[0] == '0')
    	return res.substring(1);
    return res;
    }
    
    private void writeResult(char[] result, char a, char b, int where) {
    	char original = result[where];
    	char carry = carry(a, b);
    	char digit = multiply(a, b);
    	result[where] = add(original, digit);
    	char carry2 = carry_add(original, digit);
    	sumup(carry , result, where + 1);
    	sumup(carry2, result, where + 1);
    }
    
    private void sumup(char a,char[] result, int where) {
    	char original = result[where];
    	char carry = carry_add(a, original);
    	if ( carry == '0' )
    		result[where] = add(a, original);
    	else {
    		result[where] = add(a, original);
    		sumup(carry,result, where + 1);
    	}
    		
    }
    
    private char multiply (char a, char b) {
    	int n1 = Integer.parseInt(a + "");
    	int n2 = Integer.parseInt(b + "");
    	int res = n1 * n2;
    	String result = Integer.toString(res);
    	if (result.length() == 1)
    		return result.charAt(0);
    	return result.charAt(1);
    }
    
    private char carry(char a, char b) {
    	int n1 = Integer.parseInt(a + "");
    	int n2 = Integer.parseInt(b + "");
    	int res = n1 * n2;
    	String result = Integer.toString(res);
    	if (result.length() == 1)
    		return '0';
    	return result.charAt(0);
    }
    
    private char add(char a, char b) {
    	int n1 = Integer.parseInt(a + "");
    	int n2 = Integer.parseInt(b + "");
    	int res = n1 + n2;
    	String result = Integer.toString(res);
    	if (result.length() == 1)
    		return result.charAt(0);
    	return result.charAt(1);
    }
    
    private char carry_add(char a, char b) {
    	int n1 = Integer.parseInt(a + "");
    	int n2 = Integer.parseInt(b + "");
    	int res = n1 + n2;
    	String result = Integer.toString(res);
    	if (result.length() == 1)
    		return '0';
    	return result.charAt(0);
    }
    
    

    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s1 = "999";
    	String s2 = "1";
    	String result = sol.multiply(s1, s2);
    	
    	System.out.println(result);
    	
    	
    }
}