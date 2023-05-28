// Time Complexity : O(n)
// Space Complexity : O(h) (height of tree)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int s = q.size();

            for(int i=0; i<s; i++) {
                TreeNode c = q.poll();
                if(c.left != null)
                    q.add(c.left);
                if(c.right != null)
                    q.add(c.right);
                if(i == s-1)
                    res.add(c.val);
            }
        }

        return res;
    }
}