class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null)
            return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        
        while(!queue.isEmpty())
        {
            int qsize = queue.size();
            // Resetting at the beginning of each depth
            boolean is_x_found = false;
            boolean is_y_found = false;
            for(int i=0; i<qsize;i++) // This takes only one depth of the tree
            {
                TreeNode cur = queue.poll();
                if(cur.val == x) is_x_found = true;
                if(cur.val == y) is_y_found = true;
                
                //In case if siblings are x and y
                if(cur.left != null && cur.right != null)
                {
                    if((cur.left.val == x || cur.left.val == y ) && (cur.right.val == x || cur.right.val == y))
                        return false;
                }
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
            }
            
            if(is_x_found && is_y_found) return true;
        }
        return false;
    }
}
