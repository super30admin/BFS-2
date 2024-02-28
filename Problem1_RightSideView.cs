//Time Complexity : O(n)
//Space Complexity : O(n)
//Approach : Using BFS algorithm add nodes to the queue and process each node in level order.
//If the node being processed is the first node of the level, then add the value of the node to result list at index 'level'.
//If there are more than one node in a level, update the result list at index 'level' with the value of the node being processed.
//At the end of each level, final value at index 'level' in result list will be the right most node's value for the level.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<int> RightSideView(TreeNode root) {
        List<int> result = new List<int>();
        if(root == null) return result;
        //Queue to store nodes to process in level order
        Queue<TreeNode> nodes = new Queue<TreeNode>();
        nodes.Enqueue(root);
        int level = 0;

        while(nodes.Count > 0) {
            int size = nodes.Count; // count of nodes to process in current level
            for(int i = 0; i < size; i++) {
                TreeNode cur = nodes.Dequeue(); //Get node out of queue to process
                if(result.Count == level) {
                    result.Add(cur.val); //Add current node's value to result
                }
                else
                    result[level] = cur.val; //Update current node's value to result for current level 
                //Add left and right children of the node if exists to the queue
                if(cur.left != null) {
                    nodes.Enqueue(cur.left);
                }
                if(cur.right != null) {
                    nodes.Enqueue(cur.right);
                }
            } //End of current level
            level++;
        }

    return result;
    }
}