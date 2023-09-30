// Time Complexity :O(n)
// Space Complexity : O(h) worstcase - O(n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/cousins-in-binary-tree/submissions/1062708286/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Maintain 2 variables -- x_found, y_found
 * Do a bfs traversal, check the root's left and right values matches with x and y or viceversa accordinly. 
 * if yes return false -- which concludes both are not from different parents
 * Check if current root value is same as x or y, if yes update the  x_found, y_found values, if any of the values is false return false
 */
import java.util.*;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean x_found = false;
        boolean y_found = false;
        if(root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                    if(curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if(curr.val == x)
                    x_found = true;
                if(curr.val ==y)
                    y_found = true;
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
           
            }
            if(x_found == true && y_found == true)
                return true;
            if(x_found == true || y_found == true)
                return false;
        }
        
        return true;

    }
}