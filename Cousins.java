// Time Complexity : O(V) For both approaches, we will essentially go over each element V
// Space Complexity : BFS uses an additional Queue that can conatain at most n/2 elements. n/2 would be number of leaf elements in a complete binary TreeNode
// Space Complexity : DFS uses a stack internally for recursion, without considering it O(1) space complexity.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Level order traversal. At every level compare each element againt target X & Y.
//If the elements are in the same level then they can either be siblings or cousins.
//DFS- Maintain parent along with level to verify the elements are not siblings.
//BFS- Before adding elements to the queue verify the elements are not siblings =


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
    TreeNode xParent;
    TreeNode yParent;
    int xDepth;
    int yDepth;
    int X;
    int Y;
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null) return false;
        X = x;
        Y = y;
        dfs(root, 0, null);
        if(xParent != yParent && xDepth == yDepth)
            return true;

        return false;

    }

//For DFS, we maitain depth and parent.
//If depth is same, they can be cousins or siblings.

    public void dfs(TreeNode root, int depth, TreeNode parent) {

        if(root == null)
            return;

        if(root.val == X) {
            xParent = parent;
            xDepth = depth;
        }
        if(root.val == Y) {
            yParent = parent;
            yDepth = depth;
        }

        dfs(root.left, depth+1, root);
        dfs(root.right, depth+1, root);
    }

    public boolean bfs(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            boolean bXFound = false;
            boolean bYFound = false;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if(curr.val == x) bXFound = true;
                if(curr.val == y) bYFound = true;

                if(curr.left != null && curr.right != null) {  //Check for siblings before adding the values to Queue.
                    if(curr.left.val == x && curr.right.val == y)
                        return false; //siblings not cousins
                    if(curr.left.val == y && curr.right.val == x)
                        return false; //siblings not cousins
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }

            }
            if(bXFound && bYFound) return true;
        }

        return false;
    }

}
