// Time Complexity : O(n), where n is the number of nodes
// Space Complexity : O(n), where n is the number of nodes (exactly O(n/2), last level of the tree
                        //in the queue)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//Three line explanation your code in plain English
//1. Create a queue and maintain a size variable to keep track of all the nodes at one level, 
        //and start BFS from the root node
//2. Before inserting in the queue check if the left and right child of the current node are x and y
        //if yes return false as they are siblings (this way you make sure that queue has all
        //childs at one level that are not siblings)
//3. After taking out node from the queue check if you find x and y in that level, if yes return true

// Your code here along with comments explaining your approach

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
    public boolean isCousins(TreeNode root, int x, int y) {
        //edge
        if(root == null) return false;
        Queue<TreeNode> childs = new LinkedList<>();
        childs.add(root);
        
        while(!childs.isEmpty()){
            int size = childs.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i=0; i<size; i++){
                TreeNode curr = childs.poll();
                //if you find x or y at the same level record it 
                if(curr.val == x) x_found = true;
                if(curr.val == y) y_found = true;
                
                //if both x and y are at same level but belong to same parent return false
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y || 
                        curr.right.val == x && curr.left.val == y)
                        return false;
                }
                
                if(curr.left != null) childs.add(curr.left);
                if(curr.right != null) childs.add(curr.right);
            }
            //x and y found at the same level having different parents return true
            if(x_found && y_found) return true;
            //if only one of the x and y found at a level, then return false
            if(x_found || y_found) return false;
        }
        
        return false;
    }
}