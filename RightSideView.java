// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
/*class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> child = new LinkedList<>();
        
        queue.add(root);
        result.add(root.val);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null)
                child.add(node.left);
            if(node.right!=null)
                child.add(node.right);
            if(queue.isEmpty() && !child.isEmpty()){
                result.add(child.getLast().val);
                queue = child;
                child = new LinkedList<>();
            }
            System.out.println(result);
        }
        return result;
    }
}*/
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        helper(root,0);
        return result;
    }
    
    private void helper(TreeNode root,int depth){
        if(root == null) return;
        if(result.size() == depth)
             result.add(root.val);
        else
            result.set(depth,root.val);
        result.set(depth,root.val);
        helper(root.left,depth+1);
        helper(root.right,depth+1);
    }
}
