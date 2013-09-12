package stringPermutations;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class str_perm {
	
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);
    	BufferedReader in = new BufferedReader(new FileReader(file));
    	String line;
    	str_perm sol = new str_perm();
    	while ((line = in.readLine()) != null) {
    		String[] lineArray = line.split("\\s");
    		if (lineArray.length > 0) {
    			ArrayList<String> result = sol.perm1(lineArray[0]);
    			int i = 0;
    			for (; i < result.size() - 1; i++) {
    				System.out.print(result.get(i) + ",");
    			}
    			System.out.print(result.get(i));
    			System.out.println();
    		}
    	}
    }
    
    public  static ArrayList<String> perm1(String s) {
    	char[] aArray = s.toCharArray();
    	Arrays.sort(aArray);
    	ArrayList<String> result = new ArrayList<String>();
    	perm1("", new String(aArray),result); 
    	return result;
    }
    private static void perm1(String prefix, String s,ArrayList<String> result) {
        int N = s.length();
        if (N == 0) {
        	result.add(prefix);
        }
        else {
            for (int i = 0; i < N; i++) {
            	perm1(prefix + s.charAt(i),s.substring(0, i) + s.substring(i+1, N),result);
            }          
        }
    }

}