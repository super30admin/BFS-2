// Time Complexity : O(n) where n is number of nodes in the input tree
// Space Complexity : O(n) where n is number of nodes in the input tree, nodes in the queue is order of n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class IsCousins {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean x_found = false, y_found = false;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                
                //check if curr node's left are right child are x and y and return false since they are siblings and not cousins
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y)
                       || (curr.left.val == y && curr.right.val == x)){
                        return false;
                    }
                }
                if((curr.left != null && curr.left.val == x) || (curr.right != null && curr.right.val == x)){
                    x_found = true;
                }
                if((curr.left != null && curr.left.val == y) || (curr.right != null && curr.right.val == y)){
                    y_found = true;
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            //either one found on same level that means x and y are not cousins
            if((x_found && !y_found) || (!x_found && y_found)){
                return false;
            }
            // if both found on same level that means x and y are cousins
            if(x_found && y_found) {
                return true;
            }
        }
        return true;
    }
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
}
