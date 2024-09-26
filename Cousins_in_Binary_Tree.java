import java.util.LinkedList;
import java.util.Queue;

public class Cousins_in_Binary_Tree {
	//Approach: DFS
	//1. We can find if given two nodes are cousins by using DFS, where in each level I will be maintaining the parents and the level details. 
	//2. We can also have x_parent, y_parent and x_level, y_level. So to get these details we will traverse through all the nodes and in the end will check if the levels are equal and parents are different.
	TreeNode x_parent, y_parent;
    int x_level, y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return true;
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_level == y_level;
    }
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y)
    {
        if(root == null)
            return;
        if(root.val == x)
        {
            x_parent = parent;x_level = level;
        }
        if(root.val == y)
        {
            y_parent = parent;y_level = level;
        }
        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}
//Time Complexity : O(n) 
//Space Complexity : O(n) for the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

class Solution {
	//Approach: BFS
	//1. Here I have used BFS, and a queue, so we will be checking if both nodes have different parents in the parent level, ie - when ever we encounter any node we will check if the children of that node are x and y
	//2. If so we will return false. or else we will keep traversing. While processing each node from a level, we will reset x_found and y_found in that way we will be abel to see if they are set to true in the same level again.
	//3. If x and y a re found on on the same level, return true else return false.
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean x_found = false, y_found = false;
            for(int i=0;i< size;i++)
            {
                TreeNode node = q.poll();
                if(node.val == x)x_found = true;
                if(node.val == y)                
                    y_found = true; 
                if(node.left != null && node.right != null)
                {
                    if(node.left.val == x && node.right.val == y)return false;
                    if(node.left.val == y && node.right.val  == x)return false;
                }
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            if(x_found && y_found)   
                return true;
        }
        return false;
    }
}
//Time Complexity : O(n) 
//Space Complexity : O(n) for the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}