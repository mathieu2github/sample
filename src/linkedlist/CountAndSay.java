package linkedlist;

public class CountAndSay {
	public String lookandsay(String number){
		StringBuilder result= new StringBuilder();
	 
		char repeat= number.charAt(0);
		number= number.substring(1) + " ";
		int times= 1;
	 
		for(char actual: number.toCharArray()){
			if(actual != repeat){
				result.append(times + "" + repeat);
				times= 1;
				repeat= actual;
			}else{
				times+= 1;
			}
		}
		return result.toString();
	}
	
	

	    public String countAndSay(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if (n==1) return "1";
	        
	        String num = "1";
	        
	        for ( int i = 1; i < n ; i ++ ) {
	            num = countAndSay(num);
	        }        
	        return num;      
	    }
	    
	    private String countAndSay(String number) {
	        StringBuilder result = new StringBuilder();    
	        char repeat = number.charAt(0);
	        number = number.substring(1) + " ";
	        int times = 1;
	        
	        for (char actual : number.toCharArray()) {
	            if (actual != repeat) {
	                result.append(times + "" + repeat);
	                times = 1;
	                repeat = actual;
	            }
	            else
	                times++;
	        }         
	        return result.toString();     
	    }
	
	public static void main(String[] args){
//		String num = "1"; 
//		CountAndSay cs = new CountAndSay();
//		for (int i=1;i<=10;i++) {
//			System.out.println(num);
//			num = cs.lookandsay(num);             
//		}
		
		int n = 2 ;
		CountAndSay cs = new CountAndSay();
		System.out.println(cs.countAndSay(n));
	}
	
	

}
