import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
//Space Complexity: O(h), h is the height of the tree

//here we will loop through the binary tree and 
//add element at each level of binary tree to the queue simultaneously
//while we pop each element from top of the queue,
//we make sure to add the last node from each looping cycle(i.e. the right most node)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        //creating a auxilary list of integers to return the right side view
        List<Integer> result = new ArrayList<>();
        
        //null case check
        if(root == null) return result;
        
        //creating a queue of TreeNodes to perform breath first search
        //adding the root elemne to the queue
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        //while there are elements present in the queue
        while(!que.isEmpty()) {
            
            //looping through each element present in the queue
            int size = que.size();
            for(int i = 0; i < size; i++) {
                
                //storing the node in the queue at curr and removing it
                TreeNode curr = que.poll();
                
                //the following line of code adds the curr value to the result arraylist
                //if the number of iteration equals to the last element in the queue
                //this will allow only the right most element at each level to be added to the result array
                if(i == size - 1) result.add(curr.val);
                
                //adding the left and right babies of the curr to the queue
                //this way we add new nodes at each level of binary tree together
                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
                
            }
        }
        return result;
    }
}