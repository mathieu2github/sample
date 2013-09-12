package removeDupFromSortedLLN2;


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
     ListNode result = head;
         if (head == null)
             return result;
         ListNode c = head;
         ListNode prev = null;
         boolean deleteC = false;
         while (c != null) 
         {                
             if (c.next != null && c.next.val == c.val)
             {
                 c.next = c.next.next;
                 deleteC = true;
             }
             else
             {
                 if (deleteC)
                 {
                     if (prev == null)
                         head = c.next;
                     else
                         prev.next = c.next;
                     deleteC = false;
                 }
                 prev = c;
                 c = c.next;                    
             }                                         
         }
         return result;
     }
	
    public static void main(String[] args) {
    	ListNode tenth = new ListNode(10);
    	ListNode nineth = new ListNode(10,tenth);
    	ListNode eightth = new ListNode(8,nineth);
    	ListNode seventh = new ListNode(5,eightth);
    	ListNode sixth = new ListNode(5,seventh);
    	ListNode fiveth = new ListNode(4,sixth);
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

