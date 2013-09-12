package tree;

import java.util.*;

class Node {
	public int val;
	public Node left;
	public Node right;
	
	public Node(int n) {
		val = n;
	}
	public Node() {
		
	}
	
	public Node(int n, Node left, Node right) {
		val = n;
		this.left = left;
		this.right = right;
	}
	
}

public class Solution {
	
	public LinkedList<Node> printByLevels(Node n) {
		if (n == null) return new LinkedList<Node>();
//		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<Node> temp = new LinkedList<Node>();
		LinkedList<Node> result = new LinkedList<Node>();
		temp.add(n);
		while(!temp.isEmpty()) {
			Node root = temp.pollFirst();
			result.add(root);
			if (root.left != null)
				temp.add(root.left);
			if (root.right != null)
				temp.add(root.right);
		}
		return result;
	}
	
	public LinkedList<Node> printByPreOrder(Node n) {
		if (n == null) return null;
		LinkedList<Node> result = new LinkedList<Node>();
		result.add(n);
		if (n.left != null)
			result.addAll(printByPreOrder(n.left));
		if (n.right != null)
			result.addAll(printByPreOrder(n.right));
		return result;	
	}
	
	public void print(Node n) {
		LinkedList<Node> nodes = printByLevels(n);
		System.out.println("By levels");

		while (!nodes.isEmpty()) {
			System.out.print(nodes.pollFirst().val);
			if (!nodes.isEmpty())
				System.out.print("--->");
		}

		System.out.println();
		
		System.out.println("By PreOrder");

		LinkedList<Node> nodes2 = printByPreOrder(n);
		while (!nodes2.isEmpty()) {
			System.out.print(nodes2.pollFirst().val);
			if (!nodes2.isEmpty())
				System.out.print("--->");
		}
		System.out.println();
		
		System.out.println("By InOrder");

		LinkedList<Node> nodes3 = printByInOrder(n);
		while (!nodes3.isEmpty()) {
			System.out.print(nodes3.pollFirst().val);
			if (!nodes3.isEmpty())
				System.out.print("--->");
		}
//		inOrder(n);
		System.out.println();
		
	}
	
	public LinkedList<Node> printByInOrder(Node root) {
		LinkedList<Node> result = new LinkedList<Node>();
		if( root.left !=null)
            result.addAll(printByInOrder(root.left));
        result.add(root);
        if( root.right != null)
        	result.addAll(printByInOrder(root.right));
        return result;
	}
	
	
	public Node reconstructFromPreIn(List<Node> pre, List<Node> in) {
		if (pre.size() == 0)
			return null;
		if (pre.size() != in.size())
			return null;
		if (pre.size() == 1)	return pre.get(0);
		Node root = pre.get(0);
		int index = in.indexOf(root);
		
		root.left = reconstructFromPreIn(pre.subList(1, index + 1), in.subList(0, index));
		root.right = reconstructFromPreIn(pre.subList(index + 1,pre.size()),in.subList(index + 1,in.size()));
		return root;
	}

    public void inOrder(Node root){
        if( root.left !=null)
            this.inOrder(root.left);
        System.out.println(root.val);

        if( root.right != null)
            this.inOrder(root.right);
    }
	
	public static void main(String[] args) {		
		Node n12 = new Node(12);
		Node n11 = new Node(11);
		Node n10 = new Node(10);
		Node n9 = new Node(9);
		Node n8 = new Node(8);
		Node n7 = new Node(7);
		Node n6 = new Node(6,n12,null);
		Node n5 = new Node(5,n10,n11);
		Node n4 = new Node(4,n8,n9);
		Node n3 = new Node(3,n6,n7);
		Node n2 = new Node(2,n4,n5);
		Node n1 = new Node(1,n2,n3);
		
		Solution sol = new Solution();
		sol.print(n1);
		Node nodes4 = sol.reconstructFromPreIn(sol.printByPreOrder(n1), sol.printByInOrder(n1));
		
		System.out.println("reconstruct from pre and in order");

		LinkedList<Node> nodes = sol.printByLevels(nodes4);
		System.out.println("By levels");

		while (!nodes.isEmpty()) {
			System.out.print(nodes.pollFirst().val);
			if (!nodes.isEmpty())
				System.out.print("--->");
		}
	}
}
