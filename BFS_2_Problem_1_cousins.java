//Time Complexity: O(n) As we will be traversing each node once
//Space Complexity : O(1)
//Runs successfully on leecode
//No Problem

//Here we are traversing through the tree in dfs manner. While traversing we are keeping track of previous node(parent)
//After the traversal we'll be comparing levels of those elements and their parents


public class BFS_2_Problem_1_cousins {
    int levelx;
    int levely;
    TreeNode xPrev;
    TreeNode yPrev;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,null,0,x,y);
        if(levelx == levely && xPrev != yPrev)
        {
            return true;
        }

        return false;

    }
    public void helper(TreeNode root,TreeNode prev,int level,int x,int y)
    {
        if(root == null) return;
        if(root.val == x)
        {
            levelx = level;
            xPrev = prev;
        }
        else if(root.val == y)
        {
            levely = level;
            yPrev = prev;
        }
        helper(root.left,root,level+1,x,y);
        helper(root.right,root,level+1,x,y);
    }
}
