// Time Complexity :O(n)
// Space Complexity :O(d) d is diameter of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No



class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList();

        List<Integer> result = new ArrayList();
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);

        while(!q.isEmpty()){
            int length = q.size();

            for(int i = 0; i < length; i++){
                TreeNode temp = q.poll();

                if(i == length - 1)
                    result.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        return result;
    }
}
