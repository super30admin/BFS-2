//Time Complexity: O(n)
//Space Complexity: O(n)
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size;  i++) {
                TreeNode curr = q.poll();
                if(i==0) result.add(curr.val);

                if(curr.right!=null)
                    q.offer(curr.right);
                if(curr.left != null)
                    q.offer(curr.left);

            }
        }
        return result;
    }
}
