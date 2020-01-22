// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        Boolean first = false;
        Boolean second = false;
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();		//check the length of the queue for every level and process
            
            for(int i = 0; i < len; i++){
                TreeNode temp = queue.poll();		// remove the head to process it's children
                if(temp.val == x){		// check for x
                    first = true;
                }
                
                if(temp.val == y){		// check for y
                    second = true;
                }
                
                if(first == true && second == true){		// if both are found, return true
                    return true;
                }
                
                if(temp.left != null && temp.right != null){	// if the x & y are children of the parent, return false
                    if(temp.left.val == x && temp.right.val == y){
                        return false;
                    }
                    
                    if(temp.left.val == y && temp.right.val == x){
                        return false;
                    }
                }
                
                if(temp.left != null){		// add left and right children only if it's not null
                    queue.add(temp.left);
                }
                
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            first = false;
            second = false;
        }
        
        return false;
    }
}