package generateParentheses;

import java.util.ArrayList;

public class Solutionn {
	
	 public ArrayList<String> generateParenthesis(int n) {
		 
		 ArrayList<String> result = new ArrayList<String>();
		 char[] str = new char[n+n];
		 generateParentheses(n,n,str,result,0);
		 return result;
		 
		 
	 }
	 
	 public void generateParentheses(int n, int m, char[] str, 
			 ArrayList<String>result, int count) {
		 
		 if (n < 0 || m < n)
			 return ;
		 if (  m == 0) {
			 result.add(new String(str));
			 return;
		 }
		 if (n > 0) {
				 str[count] = '(';
				 generateParentheses(n-1,m,str,result,count+1);
			 
			 if (m > n) {
				 str[count] = ')';
				 generateParentheses(n, m - 1,str, result,count+1);
			 }
		 } else {
			 str[count] = ')';
			 generateParentheses(n, m - 1,str, result,count+1);
		 }
		 
		 return; 
	 }
	 
	 public static void main(String[] args) {
		 Solutionn sol = new Solutionn();
		 ArrayList<String>result = sol.generateParenthesis(3);
	     System.out.println("new solution");
		 for(String s: result) {
			 System.out.println(s);
		 }
	    	
	 }

}
