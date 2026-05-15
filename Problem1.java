// https://leetcode.com/problems/binary-tree-right-side-view/
// Time Complexity : O(n) where n is the number of nodes in the tree.
// Space Complexity : O(n) where n is the maximum number of nodes at any level.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root== null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                if(i == size-1){
                    result.add(curr.val);
                }
            }
        }
        return result;
    }
}