class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            boolean foundX = false, foundY = false;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    foundX = true;
                } else if(curr.val == y) {
                    foundY = true;
                }
                if(curr.left != null && curr.right != null) {
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(foundX && foundY) {
                return true;
            } else if(foundX || foundY) {
                return false;
            }
        }
        return false;
    }
}