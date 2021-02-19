
//#TimeComplexity:O(N)
//#SpaceComplexity: O(N)
//#Did this code successfully run on Leetcode : Yes
//#Any problem you faced while coding this : No
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;

        Queue<Pair<TreeNode,TreeNode>> queue = new LinkedList<>();

        queue.add(new Pair<TreeNode,TreeNode>(root,null)); //initiate root

        while(!queue.isEmpty()){

            int N = queue.size();
            TreeNode parent_x = null; //reset values
            TreeNode parent_y = null;
            TreeNode child_x = new TreeNode(0);
            TreeNode child_y = new TreeNode(0);

            for(int i=0;i<N;i++){ //level order traversal
                Pair<TreeNode,TreeNode> curr = queue.poll();

                TreeNode child = curr.getKey();
                TreeNode parent = curr.getValue();

                if(child.val==x){
                    child_x = child;
                    parent_x = parent;
                }else if(child.val==y){
                    parent_y = parent;
                    child_y = child;
                }

                if(parent_x!=parent_y && child_x.val==x && child_y.val==y) //parents are not equal & child values match given x&y , so return true
                    return true;

                if(child.left!=null)
                    queue.add(new Pair<TreeNode,TreeNode>(child.left,child));

                if(child.right!=null)
                    queue.add(new Pair<TreeNode,TreeNode>(child.right,child));
            }
        }

        return false;
    }
}