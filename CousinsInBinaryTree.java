import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;
import java.util.*;

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


//Time Complexity: O(n)
//Space Complexity: O(n)

//Example:
//     (1)    Level 1
//    /   \
//  (2)   (3) Level 2
//  / \
//(4) (5)     Level 3

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        //create a queue to store nodes as we move ahead on tree level by level and initializing it with the root
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        //looping as long as there are elements in the queue, i.e. until we have iterated over each node
        while(!que.isEmpty()) {
            int size = que.size();
            
            //create flags to help us decide if two nodes are cousins
            boolean x_flag = false, y_flag = false;
            
            //looping through the nodes on each level of the tree
            for(int i = 0; i < size; i++) {
                
                //pop the topmost node from queue and storing it in curr
                TreeNode curr = que.poll();
                
                //setting the respective flags true if we find the nodes while looping
                if(curr.val == x) x_flag = true;
                if(curr.val == y) y_flag = true;
                
                //Parent check: if the same current node has two babies
                //we check if the two nodes are the two x and y values passed-in
                if(curr.left != null && curr.right != null) {
                    //if yes then we return false as they will be siblings (not cousins)
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                //after checking that left and right babies are not cousins
                //we add them to the queue
                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }
            //returning true if both nodes are on the same level
            if(x_flag && y_flag) return true;
            //returning false if both nodes are on the same level
            if(x_flag || y_flag) return false;
        }
        return false;
    }
}