package removeNthNodeFromEndOfList;


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

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int num = 1;
        if (head == null) return null;
        ListNode count = head;
        while (count.next != null) {
            num++;
            count = count.next;
        }
        
        ListNode front = head;
        
        if (n == 1) {
        	if (num == 1)  
                return null;
        	int times = num - n - 1;
        	while (times > 0) {
        		front = front.next;
        		times--;
        	}
        	front.next = null;
        	return head;	
        }  else if (n < num && n > 1) {
        	int times = num - n - 1;
        	while (times > 0) {
        		front = front.next;
                times--;
        	}
        	front.next = front.next.next;
        	return head;
        } else {
            return head.next;
        }     
    }
    
    
	public void print(ListNode head) {
		if (head == null) {
			System.out.println("The ListNode is null");
			return;
		}
			
		while (head.next != null) {
			System.out.print(head.val + "---->");
			head = head.next;
		}
		
		System.out.println(head.val +"");
	}
	
	public void print(String s) {
		System.out.println(s);
	}
    
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);
    	ListNode l6 = new ListNode(6);
    	ListNode l7 = new ListNode(7);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	l6.next = l7;
    	Solution sol = new Solution();
    	sol.print(l1);
    	sol.removeNthFromEnd(l1,3);
    	sol.print(l1);	
    }
}