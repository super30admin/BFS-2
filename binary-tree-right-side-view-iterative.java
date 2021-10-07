//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) {
            return result;
        }
        q.add(root);
        while(!q.isEmpty()) {
            int temp = 0;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                temp = node.val;
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}