// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        //we create a queue to store each level at a time
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            //calculate size
            int size = queue.size();
            
            //loop through the level
            for(int i = 0; i < size; i++){
                
                TreeNode curr = queue.poll();
                
                //get the last value and add to the list
                if(i == size - 1){
                    result.add(curr.val);
                }
                
                //add children to the queue
                if (curr.left != null) 
                    queue.add(curr.left);
                if (curr.right != null) 
                    queue.add(curr.right);
            }
        }
        
        return result;
    }
}