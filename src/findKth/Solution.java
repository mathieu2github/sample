package findKth;

import java.util.*;


public class Solution {
 class MatrixNode implements Comparable{
  int x;
  int y;
  int value;
  
  MatrixNode( int x, int y, int val) {
   this.x = x;
   this.y = y;
   value = val;
  }
  
  public int compareTo(Object other) {
   if (!(other instanceof MatrixNode)) {
    throw new ClassCastException("Invalid object");
   }
   
   MatrixNode a = (MatrixNode) other;
   
   if (this.value < a.value) return -1;
   if (this.value > a.value) return 1;
   return 0;
  }
 }
 
 public int findKthElementInSortedMatrix(int[][] m, int k) {
  PriorityQueue<MatrixNode> heap = new PriorityQueue<MatrixNode>();
  
  heap.add(new MatrixNode(0,0, m[0][0]));
  heap.add(new MatrixNode(0,1, m[0][1]));
  heap.add(new MatrixNode(1,0, m[1][0]));
  
  m[0][0] = -1;
  m[0][1] = -1;
  m[1][0] = -1;
  
  MatrixNode head = null;
  
  while (k-->0) {
   head = heap.remove();
   System.out.println("X,Y, V == " + head.x + "," + head.y + "," + head.value + ", k == " + k);
   
   if (head.x < m.length-1 && m[head.x+1][head.y] != -1) {
    heap.add(new MatrixNode(head.x+1, head.y, m[head.x+1][head.y]));
    m[head.x+1][head.y] = -1;
   }
   
   if (head.y < m[0].length-1 && m[head.x][head.y+1] != -1) {
    heap.add(new MatrixNode(head.x, head.y+1, m[head.x][head.y+1]));
    m[head.x][head.y+1] = -1;
   }
  }
  return head.value;
 }


 public static void main(String[] args) {
  Solution msort = new Solution();
  
  int[][] arr = {
    {1,   3,  5,  7,  9,  11, 13, 15, 17},
    {2,   6,  8, 12, 13,  14, 15, 16, 17},
    {8,  10, 12, 14, 16,  18, 18, 18, 18},
    {9,  10, 13, 15, 17,  19, 21, 23, 25},
    {11, 12, 13, 19, 20,  21, 24, 28, 30},
    {15, 16, 17, 19, 20,  22, 29, 30, 31},
    {18, 19, 20, 21, 22,  23, 30, 31, 33}
  };
  
  msort.findKthElementInSortedMatrix(arr, 13);
 }
}
