//Time Complexity: O(n)
//Space Complexity: O(n)
//running on leetcode: no
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        //base case
        if (root==null)
        {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //BFS
        while (!q.isEmpty())
        {
            //checking if any one of the cousins is found on the current level
            boolean x_found= false;
            boolean y_found= false;
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                if (curr.val==x)
                {
                    x_found=true;
                }
                if (curr.val==y)
                {
                    y_found=true;
                }
                if (curr.left!= null && curr.right!=null)
                {
                    if (curr.left.val == x && curr.right.val == y)//means they are siblings not cousins
                    {
                        return false;
                    }
                    if (curr.left.val==y && curr.right.val==y)
                    {
                        return false;
                    }
                }
                if (curr.left!=null){
                    q.add(curr.left);
                }
                if (curr.right!=null){
                    q.add(curr.right);
                }
                
            }
            if (x_found && y_found)
            {
                return true;
            }
            if (x_found || y_found)
            {
                return false;
            }
        }
        return false;
    }
}
