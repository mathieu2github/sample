package solution;

public class Solution_removeNthNode {
	
	   public static class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) {
	           val = x;
	           next = null;
	      }
	       
	       ListNode(int x, ListNode next) {
	    	   val = x;
	    	   this.next = next;
	       }
	   }
	  
	       public ListNode removeNthFromEnd(ListNode head, int n) {
	           // Start typing your Java solution below
	           // DO NOT write main() function
	           ListNode front = head;
	           ListNode result = head;
	           
	               
	               while ( n !=0 ) {
	                   n--;
	                   if (head == null) break;
	                   head = head.next;
	               }
	           
	               if (n > 0) return null;
	               
	               if (head == null) {
	                   return front.next;
	               }
	               
	               while ( head.next !=null) {
	                   front = front.next;
	                   head = head.next;
	               }
	           
	                   //front.val = front.next.val;
	                  // front.next = front.next.next;
	               front.next = front.next.next;
	               
	           
	           //return head;
	           return result;
	       }
	       
    public static void main(String[] args) {
    	ListNode tenth = new ListNode(10);
    	ListNode nineth = new ListNode(9,tenth);
    	ListNode eightth = new ListNode(8,nineth);
    	ListNode seventh = new ListNode(7,eightth);
    	ListNode sixth = new ListNode(6,seventh);
    	ListNode fiveth = new ListNode(5,sixth);
    	ListNode fourth = new ListNode(4,fiveth);
    	ListNode thirdth = new ListNode(3,fourth);
    	ListNode secondth = new ListNode(2,thirdth);
    	ListNode firstth = new ListNode(1,secondth);
    	
    	Solution_removeNthNode sol = new Solution_removeNthNode();
    	ListNode result = sol.removeNthFromEnd(firstth, 7);
    }
    
}
