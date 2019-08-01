import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//idea: This problem can be solved using two stacks. two stack one maintain right to left order - S1 and other maintain left to right order -S2. 
//We pop from the currentlevel-S1 stack and print the nodes value. Whenever the current level S1 order is from left to right, push the nodes left child, then its right child to the stack nextlevel-S2. 
//Since a stack is a LIFO(Last-In-First_out) structure, next time when nodes are popped off nextlevel S2, it will be in the reverse order. 
//On the other hand, for level order is from right to left - pop the nodes from S2 and store again  node's right child and then leftchild  into S1.
 


//time complexity  O(N), where Nis the number of nodes in tree
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:yes 



public class BinaryTreeZigZagLevelOrder {

	//class TreeNode
	 public static class TreeNode {
	 	int val;
	 	TreeNode left;
	 	TreeNode right;

	 	TreeNode(int value) {
	 		val = value;
	 	}
	 }
	 public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        TreeNode c=root;
	        
	        //output list
	        List<List<Integer>> ans =new ArrayList<List<Integer>>();
	        if(c==null) return ans;
	        //two stack one maintain right to left order and other maintain left to right order.
	        Stack<TreeNode> s1=new Stack<TreeNode>();
	        Stack<TreeNode> s2=new Stack<TreeNode>();
	        //first put roote element
	        s1.push(root);
	        //iterate on both stack till its empty
	            while(!s1.isEmpty()||!s2.isEmpty())
	            {
	                List<Integer> tmp=new ArrayList<Integer>();
	                
	                //pop node from S1 and store it's left and right child into S2
	                while(!s1.isEmpty())
	                {
	                        c=s1.pop();
	                        tmp.add(c.val);
	                        if(c.left!=null) s2.push(c.left);
	                        if(c.right!=null) s2.push(c.right);
	                }
	                ans.add(tmp);
	                tmp=new ArrayList<Integer>();
	                //pop node from S2 and store it's right first and left child into S1
	                while(!s2.isEmpty())
	                {
	                        c=s2.pop();
	                        tmp.add(c.val);
	                        if(c.right!=null)s1.push(c.right);
	                        if(c.left!=null)s1.push(c.left);
	                }
	                if(!tmp.isEmpty()) ans.add(tmp);
	            }
	        return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode nums = new TreeNode(3);
		nums.left =new TreeNode(9);
		nums.right = new TreeNode(20);
		nums.right.left = new TreeNode(15);
		nums.right.right = new TreeNode(7);
	     List<List<Integer>> ans =new ArrayList<List<Integer>>();
	     ans = zigzagLevelOrder(nums);
	     for (int index = 0; index < ans.size(); index++) {
	    //	 for (int val = index; val < ans.get(index).size(); val++) {
	    		 	System.out.println("zigzag order is ="+ans.get(index));
	    	// }
		}
	}

}
