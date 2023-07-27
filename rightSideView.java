// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(n), where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Use BFS to traverse the tree level by level
 * 2. If the node is the last node in the level, add it to the result
 * 3. Return the result
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> leftView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode currNode = queue.poll();
                if(i==0){
                    leftView.add(currNode.val);
                }

                if(i == size-1){
                    result.add(currNode.val);
                }

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }

                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
        }
        
        System.out.print(leftView);
        return result;
    }
}