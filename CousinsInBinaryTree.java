
//Solution 1: DFS
// keeping track of the path of the two given nodes
// for the nodes to be cousins, they should be having different parents and same depth

//TC: O(n)
//SC: O(h)

class Solution {

    TreeNode parent_x;
    TreeNode parent_y;
    int depth_x;
    int depth_y;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return parent_x != parent_y && depth_y == depth_x;
    }

    public void dfs(TreeNode root, TreeNode parent, int x, int y, int depth)
    {
        //base 
        if(root == null) return;

        dfs(root.left,root,x,y,depth+1);
        //logic
        if(root.val == x)
        {
            parent_x = parent;
            depth_x = depth;
        }

        if(root.val == y)
        {
            parent_y = parent;
            depth_y = depth;
        }

      
        dfs(root.right,root,x,y,depth+1);

    }
}

//Solution 2: BFS
// with every iteration of BFS we keep track of the parent by adding to the parent queue
// the queue will in turn help us to keep track of the depth
// this way we can get the result
//TC :O(n)
//SC: O(n)

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        
        q.add(root);
        pq.add(null);

        while(!q.isEmpty())
        {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            TreeNode parent_x = null;
            TreeNode parent_y = null;

            for(int i=0; i<size;i++)
            {
                TreeNode curr = q.poll();
                TreeNode currP = pq.poll();

                if(curr.val == x){
                    x_found = true;
                    parent_x = currP;
                }

                if(curr.val == y)
                {
                    y_found = true;
                    parent_y = currP;
                }

                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }

                if(curr.left!=null){
                    q.add(curr.left);
                    pq.add(curr);
                }

                if(curr.right!=null)
                {
                    q.add(curr.right);
                    pq.add(curr);
                }
            }

            if(x_found && y_found)
            {
                return parent_x != parent_y;
            }

            if(x_found || y_found)
            {
                return false;
            }
        }

        return false;
    }
}

