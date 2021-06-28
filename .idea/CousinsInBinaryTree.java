public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//DFS
class CousinsInBinaryTree {
    int xdepth;
    int ydepth;
    TreeNode xparent;
    TreeNode yparent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null,0,x,y);
        return xdepth == ydepth && xparent!=yparent;

    }
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y)
    {
        //base
        if(root==null)
            return;
        //logic
        if(x== root.val)
        {
            xdepth = depth;
            xparent = parent;

        }
        if(y== root.val)
        {
            ydepth = depth;
            yparent = parent;

        }
        dfs(root.left,root , depth + 1, x, y);
        dfs(root.right,root , depth + 1, x,y);
    }
}


// time complexity is O(n)
//Space compelxity is O(n)



//BFS
class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean xfound=false;
            boolean yfound=false;
            for(int i = 0;i<size; i++)
            {   TreeNode temp = q.poll();
                if(x==temp.val)
                    xfound = true;
                if(y==temp.val)
                    yfound = true;
                if(temp.left!=null && temp.right!=null)
                {
                    if(x==temp.left.val && y == temp.right.val)
                        return false;
                    if(y==temp.left.val && x == temp.right.val)
                        return false;
                }
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            if(xfound && yfound)
                return true;
            if(xfound|| yfound)
                return false;
        }
        return false;
    }
}



// time complexity is O(n)
//Space compelxity is O(breadth)
