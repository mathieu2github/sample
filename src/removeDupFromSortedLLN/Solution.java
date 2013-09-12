package removeDupFromSortedLLN;

import solution.Solution_removeNthNode.ListNode;

public class Solution {
	
	   private static class ListNode {
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
	   
	   
	   public ListNode deleteDuplicates(ListNode head) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if ( head == null) return null;
	        ListNode result = head;
	        
	        ListNode previous = head;
	        ListNode current = previous.next;
	        
	        while (current != null) {
	            while ( previous.val == current.val) {
	            	current = current.next;
	            	if (current == null)
	            		break;
	            }
	            
	            if (current == null) {
	            	previous.next = current;
	            	return head;
	            }
	            	
	            
	            previous.next = current;
	            previous = current;
	            current = current.next;
	        }
	        
	        return head;
	  
	    }
    
    public static void main(String[] args) {
    	ListNode tenth = new ListNode(10);
    	ListNode nineth = new ListNode(10,tenth);
    	ListNode eightth = new ListNode(8,nineth);
    	ListNode seventh = new ListNode(5,eightth);
    	ListNode sixth = new ListNode(5,seventh);
    	ListNode fiveth = new ListNode(5,sixth);
    	ListNode fourth = new ListNode(4,fiveth);
    	ListNode thirdth = new ListNode(3,fourth);
    	ListNode secondth = new ListNode(2,thirdth);
    	ListNode firstth = new ListNode(2,secondth);
    	
    	Solution sol = new Solution();
    	ListNode result = sol.deleteDuplicates(firstth);
    	while (result != null) {
    		System.out.print(result.val + "-->");
    		result = result.next;
    	}
    	
    }
}