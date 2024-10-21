
// Time Complexity : O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

 //aesha 
 //bfs
 class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Boolean x_found=false ,y_found=false;
        TreeNode x_parent =null, y_parent = null;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();

        q.add(root);
        pq.add(null);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode curr = q.poll();
                TreeNode parent = pq.poll();

                if(curr.val == x)
                {
                    x_found = true;
                    x_parent = parent;
                }
                if(curr.val == y)
                {
                    y_found = true;
                    y_parent = parent;
                }
                if(curr.left!= null)
                {
                    q.add(curr.left);
                    pq.add(curr);
                }
                if(curr.right!= null)
                {
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            if(x_found && y_found) return x_parent!=y_parent;
            if(x_found || y_found) return false;
        }
        return false;
    }
}