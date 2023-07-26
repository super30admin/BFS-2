//Using BFS

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    public List<Integer> rightSideView(TreeNode root) {
        //Result to store the the result
        List<Integer> result = new ArrayList<>();
        //null check
        if(root == null) return result;
        //Queue to store the nodes which are to be precessed
        Queue<TreeNode> q = new LinkedList<>();
        //Adding the root in queue
        q.add(root);

        //run the loop till there are elements in queue
        //process the elements in queue and add it's children if they exist
        //Get the the size in the beginning of processing each level and when the node is the last node in the level, store it's value in result
        while(q.peek()!=null){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode temp = q.remove();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                if(i == size-1) result.add(temp.val);

            }

            
        }
        return result;
    }
}