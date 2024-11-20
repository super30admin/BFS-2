// Time Complexity :O(n)/
// Space Complexity :O(n)// 
// Did this code successfully run on Leetcode :Yes
//Runtime: 1 ms, faster than 66.77% of Java online submissions for Cousins in Binary Tree.
//Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Cousins in Binary Tree.
// Any problem you faced while coding this :No, as already discussed in class
import java.util.*;
import java.io.*;
//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x){
//		val=x;
//	}
//}
public class LC_993_CousinsInBT {
	TreeNode root;
	public static boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        //Declare and queue and add root into it
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //Traverse the queue till its empty
        while(!q.isEmpty()){
            int size= q.size();
            boolean flag_x=false, flag_y=false;
            //traverse the queue till its length, remove node from queue & add the corresponding left& right 
            //child in the queue.
            for(int i=0;i<size;i++){
                TreeNode node= q.poll();
                //Check if the x&y are child of siblings, and return false
                if(node.left !=null && node.right!=null){
                    if(node.left.val == x && node.right.val ==y) return false;
                    if(node.left.val == y && node.right.val == x) return false;   
                }
                //set flag true if x and y found
                if(node.val==x) flag_x=true;
                else if(node.val==y) flag_y=true;
                if(node.left !=null)  q.add(node.left);
                if(node.right !=null)  q.add(node.right); 
            }    
            if(flag_x && flag_y ) return true;
        }
        return false;
    }
	
	 public static void main(String[] args) {
		 LC_993_CousinsInBT tree= new LC_993_CousinsInBT();
			tree.root= new TreeNode(1);
			tree.root.left= new TreeNode(2);
			tree.root.right= new TreeNode(3);
			tree.root.left.left= new TreeNode(4);
			int x= 4,y=3;
			System.out.println("Are x & y cousins?: " + isCousins(tree.root,x,y) );
			
		
		}
	   
}
