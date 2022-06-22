// https://leetcode.com/problems/binary-tree-right-side-view/submissions/

// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

// BFS solution
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(i == size - 1) result.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        
        return result;
    }
}