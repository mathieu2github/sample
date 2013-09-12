package rotateList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
public class Solution {
	
	public void print(ListNode head) {
		while (head.next != null) {
			System.out.print(head.val + "---->");
			head = head.next;
		}
		System.out.println(head.val +"");
	}
	
	public void print(String s) {
		System.out.println(s);
	}
	
	public ListNode rotateRight(ListNode head, int n) {
        int num = 1;
        if (head == null) return null;
        ListNode count = head;
        while (count.next != null) {
            num++;
            count = count.next;
        }
        
        n %= num;
        n = num - n;
        while (n != 0) {
        	n--;
        	rotateRight(head);
        }
        return head;
	}
    public void rotateRight(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int num = 1;
        if (head == null) return;
        ListNode count = head;
        while (count.next != null) {
            num++;
            count = count.next;
        }
        
//        print("number of nodes are " + num);        
//        print("number of moves needed is " + n);
        
        int start = 0;
        ListNode tail = head;

        
//        print(tail);
        
        while(tail.next != null && num != 0) {
        	num--;
        	swap(tail);
        	tail = tail.next;
        }
//        print(head);  
//        return head;     
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
    	sol.rotateRight(l1,13);
    	sol.print(l1);



    	
    }
}