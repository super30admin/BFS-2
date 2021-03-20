// Time Complexity : O(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Using DFS recursive approach with track of x and y parents and depth
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode parentX = null, parentY = null;
    int depthX = -1,depthY = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return true;
        recursion(root,x,y,0);
        return (depthX != -1 && depthY != -1 && (depthX == depthY) && (parentX != parentY));
    }
    public void recursion(TreeNode root, int x,int y,int depth){
        if(root == null) return;
        depth++;
        if((root.left != null && root.left.val == x) || ( root.right!= null && root.right.val == x)){
            parentX = root;
            depthX = depth;
        }
        else if((root.right != null && root.right.val == y) || (root.left!= null && root.left.val == y)){
            parentY = root;
            depthY = depth;
        }
        if(root.left != null) recursion(root.left,x,y,depth);
        if(root.right != null) recursion(root.right,x,y,depth);
    }
}


// Using BFS iterative Approach
/*
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return true;
        int parentX = -1,parentY = -1;
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            parentX = -1;
            parentY = -1;
            for(int i=0;i<size;i++){
                TreeNode node = que.remove();
                if((node.left != null  && node.left.val == x) || (node.right != null && node.right.val == x))
                    parentX = node.val;
                else if((node.right != null && node.right.val == y) || (node.left != null  && node.left.val == y ))
                    parentY = node.val;
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            if(parentX != parentY && parentX != -1 && parentY != -1) return true;
        }
        return false;
    }
}
*/
