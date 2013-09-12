package mergeKSortedLists;



/**
 Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 */
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
import java.util.ArrayList;
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (lists == null) return null;
        
        if (lists.size() == 0) return null;
        if (lists.get(0) == null) return null;
        
        ListNode kaishi = lists.get(0);
    	ListNode result = null;
        
        if (lists.size() == 1) return kaishi;
    	
    	for (int i = 1; i < lists.size(); i++) {
    		result = mergeTwo(kaishi,lists.get(i));
    	}
    	
        
    	return result;

        
    }
    
    public ListNode mergeTwo(ListNode n1, ListNode n2) {
        if ( n1 == null) return n2;
        if ( n2 == null) return n1;
    	ListNode head = null;
    	ListNode front = null;
    	if ( n1.val <= n2.val) {
    		head = n1;
    		front = n1;
    		n1 = n1.next;
    	} else {
    		head = n2;
    		front = n1;
    		n2 = n2.next;
    	}

    		
    	while (n1 != null && n2 != null) {
    		if (n1.val <= n2.val) {
    			head.next = n1;
    	   		n1 = n1.next;
        		head = head.next;
    		} else {
        		head.next = n2;
        		n2 = n2.next;
        		head = head.next;
    		}
    	}
    	
    	if ( n1 == null) {
            while ( n2 != null) {
                head.next = n2;
            	n2 = n2.next;
        		head = head.next;
            }      	
    	}
    	if ( n2 == null) {
            while ( n1 != null) {
                head.next = n1;
                n1 = n1.next;
        		head = head.next;
            }
    	}
    	
    	return front;
    }

    
    
    public static void main(String[] args) {
       	Solution sol = new Solution();
    //	ListNode n = new ListNode(1);
    	ArrayList<ListNode> sample = new ArrayList<ListNode>();
    //	sample.add(n);
    	ListNode result = sol.mergeKLists(sample);
    }
}
    