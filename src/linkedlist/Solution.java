package linkedlist;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	
	public static void main (String[] args) {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(0);
		
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(8);
		ListNode n6 = new ListNode(2);
		
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;
		Solution sol = new Solution();
		ListNode n7 = sol.addTwoNumbers(n1,n4);
		n7.printOut(n7);
		
		
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersWithCarryOn(l1,l2,0);
   
    }
    
    public ListNode addTwoNumbersWithCarryOn(ListNode l1, ListNode l2, int carry_on) {
        if ( l1 == null && l2 == null && carry_on == 0) return null;
        ListNode result = new ListNode(carry_on);
        
        int value = carry_on;
        
        if (l1 != null)
        value += l1.val;
        
        if (l2 != null)
        value += l2.val;
        
        result.val = value%10;
        
        ListNode next_digit  = addTwoNumbersWithCarryOn(l1 == null ? null : l1.next,
                                                        l2 == null ? null : l2.next,
                                                        value >=10 ? 1:0);
        result.next = next_digit;
        return result;         
    }
}