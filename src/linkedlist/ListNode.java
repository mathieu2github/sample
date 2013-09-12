package linkedlist;

public class ListNode {
     int val;
     ListNode next;
	 ListNode(int x) {
	 val = x;
	 next = null;
	 }
	 
	 void printOut(ListNode n) {
			 if (n.next != null) {
				 System.out.print(n.val + "--->" + "");
				 printOut(n.next);
			 }
			 else 
				 System.out.print(n.val);
	 }
}
