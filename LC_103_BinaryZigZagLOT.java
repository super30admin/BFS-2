// Time Complexity :O(n)/
// Space Complexity :O(n)// 
// Did this code successfully run on Leetcode :Yes
//Runtime: 1 ms, faster than 96.05% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
//Memory Usage: 36 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// Any problem you faced while coding this :No, as already discussed in class
import java.util.*;
import java.io.*;
public class LC_103_BinaryZigZagLOT {
	TreeNode root;
	 public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> result= new ArrayList<List<Integer>>();
	        //Base condition
	        if(root == null) return result;
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        boolean leftToRight= true;
	        //Traverse queue until its empty
	        while(!q.isEmpty()){
	            int size= q.size();
	            List<Integer> temp= new ArrayList<Integer>();
	            
	            for(int i=0; i<size;i++){
	                TreeNode node= q.poll();
	                //check for child nodes and add to the queue
	                if(node.left!=null) q.add(node.left);
	                if(node.right!=null) q.add(node.right);
	                temp.add(node.val);       
	            }
	            //if left to right flag is false, reverse the list & then add to temp
	            if(leftToRight==true){
	                result.add(temp);
	                leftToRight =false;
	            }
	            else{
	                Collections.reverse(temp);
	                result.add(temp);
	                leftToRight =true;
	            }

	        }
	        return result;   
	  }
	 public static void main(String[] args) {
		 LC_103_BinaryZigZagLOT tree= new LC_103_BinaryZigZagLOT();
			tree.root= new TreeNode(3);
			tree.root.left= new TreeNode(9);
			tree.root.right= new TreeNode(20);
			tree.root.left.left= new TreeNode(15);
			tree.root.right.right= new TreeNode(7);
	
			System.out.println("Zig Zag Level order traversal is: " + zigzagLevelOrder(tree.root) );
			
		
		}

}
