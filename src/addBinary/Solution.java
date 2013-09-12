package addBinary;

public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        int m = first.length;
        int n = second.length;
        int digits = m > n ? m : n;
        int xiaoyu = m < n ? m : n;
        char[] result = new char[digits];
        
        char carry_on = '0';
        
        for (int i  = 0 ; i < xiaoyu ; i++) {
            result[digits - 1 -i] = addBinary(first[m - 1 - i], second[n - 1 - i], carry_on);
            carry_on = getCarryOn(first[m - 1 - i], second[n - 1 - i], carry_on);
        }
        
        
        
        
    }
    
    public char addBinary(char a, char b, char c) {
        if      (a == '0' && b == '0' && c == '0') 
            return '0';
        else if (a == '0' && b == '0' && c == '1')
            return '1';
        else if (a == '0' && b == '1' && c == '0')
            return '1';
        else if (a == '0' && b == '1' && c == '1')
            return '0';
        else if (a == '1' && b == '0' && c == '0')
            return '1';
        else if (a == '1' && b == '0' && c == '1')
            return '0';
        else if (a == '1' && b == '1' && c == '0')
            return '0';
        else 
            return '1';   
    }
    
    public char getCarryOn(char a, char b, char c) {
        if      (a == '0' && b == '0' && c == '0') 
            return '0';
        else if (a == '0' && b == '0' && c == '1')
            return '0';
        else if (a == '0' && b == '1' && c == '0')
            return '0';
        else if (a == '0' && b == '1' && c == '1')
            return '1';
        else if (a == '1' && b == '0' && c == '0')
            return '0';
        else if (a == '1' && b == '0' && c == '1')
            return '1';
        else if (a == '1' && b == '1' && c == '0')
            return '1';
        else 
            return '1';   
    }
    
    
}