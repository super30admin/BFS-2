// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
BFS approach using a queue but checking size after adding all children and adding only right most element of that level to the list
 */
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
    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();

        if(root==null){
            return res;
        }


        Queue<TreeNode> queue = new LinkedList<>();

        int size=1;
        queue.add(root);
        while(!queue.isEmpty()){


            for(int i=0;i<size;i++){
                TreeNode value=queue.remove();
                if(i==size-1){
                    res.add(value.val);
                }

                if(value.left!=null){
                    queue.add(value.left);
                }
                if(value.right!=null){
                    queue.add(value.right);
                }
            }
            size=queue.size();
        }

        return res;
    }
}