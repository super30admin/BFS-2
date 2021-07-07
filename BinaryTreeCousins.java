/*
 * #993. Cousins in Binary Tree
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:
Refer leetcode

Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Refer leetcode

Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Refer leetcode


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

1. The number of nodes in the tree will be between 2 and 100.
2. Each node has a unique integer value from 1 to 100.

 */


/*
 * Time Complexity: O (N) -> To traverse the 'N' nodes of a Binary tree
 * 
 * Space Complexity: O (N) -> To store 'N' nodes of a Binary tree
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.BFS2;

// Definition for a binary tree node.
class TreeNode7 {
	int val;
	TreeNode7 left;
	TreeNode7 right;
	TreeNode7() {}
	TreeNode7(int val) { this.val = val; }
	TreeNode7(int val, TreeNode7 left, TreeNode7 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreeCousins {
	 /*
	    * For this problem, we dont need to return the depth and parent of a node to other node in recursive calls since the values from one node is not dependent on other, so return type of recursive function is void...
	    * Since, we are not returning, we define the depth and parent variables for x and y globally
	    * depth to -1 and parent to null 
	    */
	    
	    int depthX = -1;
	    int depthY = -1;
	    
	    TreeNode7 parentX = null;
	    TreeNode7 parentY = null;
	    
	    // Function to start the recursive calls and return result after done with recursion
	    public boolean isCousins(TreeNode7 root, int x, int y) { 
	        
	        // Start the recursive call (DFS)
	        // starting with root node, depth 0 and parent of root node as null
	        recurr(root, x, y, 0, null); 
	        
	        // check both conditions for x and y to be cousins and return either true or false
	        return (depthX == depthY) && (parentX != parentY);
	    }
	    
	    // Recursive function
	    public void recurr(TreeNode7 root, int x, int y, int depth, TreeNode7 parent){
	        /* Base case */
	        
	        // 1. If root is null, no binary tree, return the control to calling function (isCousins)
	        // 2. If while traversing tree recursively, if we reach leaf node, then return the control to recursive calls to explore other branches
	        if(root == null){
	            return;
	        }
	        
	        /*
	        * Top Down approach
	        *
	        * While traversing recursively, starting from root node, at all nodes, we first check 
	        * if that node's value is either equal to x or y
	        * If yes, then update its depth and parent and then recursive call on its left child
	        * If not, then skip update part, and do recursive call on its left child
	        */
	        
	        /* Recursive case */
	        
	        // 1. Conditional statements
	        if(root.val == x){
	            depthX = depth;
	            parentX = parent;
	        }
	        else if(root.val == y){
	            depthY = depth;
	            parentY = parent;
	        }
	        
	        // After finding both x and y and updating their depth and parent
	        // We don't need to explore other branches/nodes of a tree, so explicitly stop recursion
	        
	        // If condition to stop recursion
	        if(depthX != -1 && depthY != -1){ // We have found both x and y
	            return; // This will return the control to calling function (isCousins)
	        }
	        
	        // 2. Recursive calls
	        // If not found both x and y, continue the recursive calls on left and right child
	        recurr(root.left, x, y, depth+1, root);
	        recurr(root.right, x, y, depth+1, root);
	    }
	    
}
