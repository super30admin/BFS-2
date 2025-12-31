//TC: O(n)
//SC: O(1)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.right != null) q.add(curr.right);
                if(curr.left != null) q.add(curr.left);
                if(i==0) {
                    result.add(curr.val);
                }
            }
        }
        return result;
    }
}