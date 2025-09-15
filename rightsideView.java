// Time Complexity: O(N) where N is the number of nodes in the binary tree
// Space Complexity: O(N) where N is the number of nodes in the binary tree(O(N/2) for the queue when the binary tree is full since at the last level there can be at most N/2 nodes)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
/**
 * Here is the code for finding the right side view of a binary tree using level order traversal (BFS).
 * We use a queue to perform the level order traversal and keep track of the last node at each level, which represents the rightmost node visible from that level.
 * We add the value of this node to the result list. Once we come out of the for loop, the currNode will be the rightmost node of that level.
 * We continue this process until we have traversed all levels of the tree.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            TreeNode currNode=null;
            for(int i=0;i<size;i++)
            {
                currNode=q.poll();
                if(currNode.left!=null)
                {
                    q.add(currNode.left);
                }
                if(currNode.right!=null)
                {
                    q.add(currNode.right);
                }
            }
            result.add(currNode.val);

        }

        return result;
        
        
    }
}