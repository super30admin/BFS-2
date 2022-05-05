// bfs solution
// TC O(N) SC O(N)
// trick is to add the last element of each level to the result array
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(i == size - 1) {
                    result.add(cur.val);
                }
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return result;
    }
}