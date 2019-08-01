
//idea:  recrusive solution.
//store depth and parents of each node in two separate hashmap and compare.
//if depth is same and parents are difference then those nodes are cusines.
//time complexity o(n)  n is no of ndoes in tree
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:no

import java.util.HashMap;
 class CousinesInBinaryTree {

	//class TreeNode
	 public static class TreeNode {
	 	int val;
	 	TreeNode left;
	 	TreeNode right;

	 	TreeNode(int value) {
	 		val = value;
	 	}
	 }
	  //two stack depth and parent
     public static HashMap<Integer, Integer> depth;
     public static HashMap<Integer,TreeNode> parent;  
     
     
     //method to check isCousines or not
    public static boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parent = new HashMap<>();
        helper(root, null);    
        if(depth.get(x) == depth.get(y) && parent.get(x)!=parent.get(y)) return true;
        return false;
    }
    
    //helper function to store depth and parent of each nodes
    public static void helper(TreeNode node, TreeNode par){
        if(node!=null){
            depth.put(node.val, par!=null ? 1+depth.get(par.val):0);
            parent.put(node.val, par);
            helper(node.left, node);
            helper(node.right, node);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode nums = new TreeNode(1);
		nums.left =new TreeNode(2);
		nums.right = new TreeNode(3);
		boolean isCousine = isCousins(nums, 2,3);
		System.out.println("isCousine="+isCousine);
	}

}
