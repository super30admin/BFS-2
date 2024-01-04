// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : BFS

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        boolean x_exists, y_exists;

        while(!q.isEmpty())
        {
            x_exists = y_exists = false;
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();

                if(node.val == x) x_exists = true;
                else if(node.val == y) y_exists = true;

                if(node.left != null && node.right != null)
                {
                    if( (node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x) ) return false;
                }

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            if(x_exists == true && y_exists == true) return true;

            // different level
            else if(x_exists == true || y_exists == true) return false;
        }
        return false;
    }
}