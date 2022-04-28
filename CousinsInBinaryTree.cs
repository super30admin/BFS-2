// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//DFS Approach
//O(n), O(h)
int xLvl = 0, yLvl = 0;
int xParent = 0, yParent = 0;
public bool IsCousins(TreeNode root, int x, int y) {
    if(root == null)
        return false;
    
    dfs(root, 0, null, x, y);
    
    return xLvl == yLvl && xParent != yParent;
}

private void dfs(TreeNode root, int level, TreeNode parent, int x, int y)
{
    
    //base condition
    if(root == null)
        return;
    
    //logic
    if(root.val == x)
    {
        xLvl = level;
        xParent = parent == null ? 0 : parent.val;
    }
    
    if(root.val == y)
    {
        yLvl = level;
        yParent = parent == null ? 0 : parent.val;
    }
    dfs(root.left, level + 1, root, x, y);
    dfs(root.right, level + 1, root, x, y);   
}


//BFS
//O(n), O(n)
public bool IsCousins(TreeNode root, int x, int y) {
    if(root == null)
        return false;
    
    
    Queue<TreeNode> queue = new Queue<TreeNode>();
    queue.Enqueue(root);
    
    while(queue.Count > 0)
    {
        int size = queue.Count;
        bool xFound = false, yFound = false;
        for(int i = 0; i < size; i++)
        {
            var curr = queue.Dequeue();
            if(x == curr.val)
                xFound = true;
            if(curr.val == y)
                yFound = true;
            
            if(curr.left != null && curr.right != null)
            {
                //check if they have same parent
                if(curr.left.val == x && curr.right.val == y)
                    return false;
                
                if(curr.left.val == y && curr.right.val == x)
                    return false;
            }
            
            if(curr.left != null)
                queue.Enqueue(curr.left);
            
            if(curr.right != null)
                queue.Enqueue(curr.right);
        }
        //both are found
        if(xFound && yFound)
            return true;
        
        //only one is found
        if(xFound || yFound)
            return false;
    }
    return false;
}