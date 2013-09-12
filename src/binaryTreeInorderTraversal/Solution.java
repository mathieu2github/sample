package binaryTreeInorderTraversal;

import java.util.ArrayList;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        inorderTraversal(root, result);
    
        return result;              
    }
    

    public static void main(String[] args) {
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	n1.left = n2;
    	
    	Solution sol = new Solution();
    	System.out.println(sol.inorderTraversal(n1));

    }
    
    public void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if ( root == null)
            return;
            
        TreeNode current = root;
        TreeNode pre = null;
        
//        while ( current != null) {
            
            if (current.left == null) {
            		
            	result.add(current.val);
            	current = current.right;
            	inorderTraversal(current, result);
            	
            }
            
            else  {
                pre = current.left;
                while(pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                    inorderTraversal(current, result);
                }
                else {
                    pre.right = null;
                    result.add(current.val);
                    current = current.right;
                    inorderTraversal(current, result);
                }        
            }   
//        }    
    }
    
//    public void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
//        if ( root == null)
//            return;
//            
//        TreeNode current = root;
//        TreeNode pre = null;
//        
//        while ( current != null) {
//            
//            if (current.left == null) {
//            		
//            	result.add(current.val);
//            	current = current.right;
//            	
//            }
//            
//            else  {
//                pre = current.left;
//                while(pre.right != null && pre.right != current) {
//                    pre = pre.right;
//                }
//                
//                if (pre.right == null) {
//                    pre.right = current;
//                    current = current.left;
//                }
//                else {
//                    pre.right = null;
//                    result.add(current.val);
//                    current = current.right;
//                }        
//            }   
//        }    
//    }
    
}