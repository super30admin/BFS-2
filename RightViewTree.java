// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We perform a level order traversal of a tree and add the last element of each level in the array
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) return new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        List<Integer> result = new ArrayList<>();
        
        while (!q.isEmpty()){
            int size = q.size();
            Integer levelNode = 0;
            for (int i=0; i<size; i++){
                TreeNode node = q.poll();
                levelNode = node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(levelNode);
        }
        return result;
    }
}