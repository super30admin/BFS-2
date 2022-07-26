// Time Complexity: O(N), N = total number of nodes
// Space Complexity: O(N), N = total number of nodes

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean xFound = false, yFound = false;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.val == x)
                    xFound = true;
                if(curr.val == y)
                    yFound = true;
                
                // sibling check
                if(curr.left != null && curr.right != null) {
                    int val1 = curr.left.val;
                    int val2 = curr.right.val;
                    if((x == val1 && y == val2) || (x == val2 && y == val1))
                        return false;
                }
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            if(xFound && yFound)
                return true;
            if(xFound || yFound)
                return false;
        }
        return false;
    }
}
