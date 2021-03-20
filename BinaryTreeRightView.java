// Time Complexity : o(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using Level order traveral to get the nodes at each level and get the last node of each level.

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
        List<Integer> result= new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                if(i == size-1) result.add(que.peek().val);
                TreeNode node = que.remove();
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
        }
        return result;
    }
}

/* Recursive Approach 
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        levelOrder(root,0);
        return result;
    }
    public void levelOrder(TreeNode node, int level){
        if(node == null) return;
        if(level == result.size())
            result.add(node.val);
        levelOrder(node.right, level+1);
        levelOrder(node.left,level+1);
    }
}
*/
