//Tc: O(n)
//Sc: O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode first = null;
        if(root != null)
            q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0 ; i<size ; i++) {
                TreeNode node = q.remove(); 
                if(node.left != null) {
                    q.add(node.left);
                    if(first != null && (node.left.val == x || node.left.val == y)) {
                        if(first != node) {
                            return true;
                        }
                    } else if(node.left.val == x || node.left.val == y) {
                        first = node;
                    }
                } 
                if(node.right != null)  {
                    q.add(node.right);
                    if(first != null && (node.right.val == x || node.right.val == y)) {
                        if(first != node) {
                            return true;
                        }
                    } else if(node.right.val == x || node.right.val == y) {
                        first = node;
                    }
                }
                if(first != null && i == size-1)
                    return false;
            }
            
        }
        return true;
    }
}
