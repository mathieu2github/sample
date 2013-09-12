package rotateNodesInKGroup;

//import rotateNodesInKGroup.ListNode;
//import rotateNodesInKGroup.Solution;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int num = 1;
        if (head == null) return null;
        ListNode count = head;
        while (count.next != null) {
            num++;
            count = count.next;
        }
        if (num/k <1)
        	return head;
        int times = num/k;
        
        ListNode front = head;
        int nodes = 0;
        while (times > 0) {
        	times--;
        	nodes = k;
        	rotate(front, k);
        	while (nodes > 0) {
        		front = front.next;
        		nodes--;
        	}
//        	print("front after loop : ");
        	print(front);       		
        }
        
        return head;
    }
    
    public void rotate(ListNode front, int k) {
    	int times = k/2;
    	int index = 0;
    	while (times > 0) {
    		swap(front, index, k);
    		index++;
    		times--;
    	}
//    	print("after 1 time of reverse the front" );
//    	print(front);
    }
    
    public void swap(ListNode front, int index, int k) {
    	int anti_index = k - index -  1;
    	ListNode head = front;
    	ListNode tail = front;
    	while (index > 0) {
    		head = head.next;
    		index--;
    	}
    	
    	while (anti_index > 0) {
    		tail = tail.next;
    		anti_index--;
    	}
    	
    	int temp = head.val;
    	head.val = tail.val;
    	tail.val = temp;
    }
    
    public void swap(ListNode head) {
        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;
    }
    
//    public void swap(ListNode tail, ListNode front) {
//    	int temp = tail.val;
//    	tail.val = front.val;
//    	front.val = temp;
//    }
    
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
    	sol.reverseKGroup(l1,2);
    	sol.print(l1);	
    	
    	System.out.println(Integer.MAX_VALUE + 1);
    	System.out.println(Integer.MIN_VALUE);
    	System.out.println(Integer.MIN_VALUE - 1);
    	System.out.println(Integer.MAX_VALUE);

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
}