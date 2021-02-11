//TC - O(n)
//SC - O(n)
class Solution {
      public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();
                if(i == 0)
                    result.add(curr.val);
                if(curr.right != null) q.add(curr.right);
                if(curr.left != null) q.add(curr.left);
            }
        }
        return result;
    } 
}
