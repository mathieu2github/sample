package reverseLinkedList;



class Node {
	int value;
	Node next;	
	
	public Node(int n) {
		this.value = n;
	}
	
	
}


public class Solution {
	
	public Node reverseLinkedList(Node head) {
		
		if (head == null)
			return null;
		
		Node current = head;
		Node next = head.next;
		Node loop = null;
		
		while (next != null) {
			current.next = loop;
			loop = current;
			current = next;
			next = next.next;
		}
		
		current.next = loop;
		return current;		
		
	}
	
	public void print(Node n) {
		System.out.print(n.value + "--->");
		if (n.next == null) {
			System.out.print(" null ");
			System.out.println();
			return;
		}
		print(n.next);
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		Solution sol = new Solution();
		sol.print(n1);
		Node res = sol.reverseLinkedList(n1);
		sol.print(res);

	}
	
}
