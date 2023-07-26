// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS: We need to find if x and y belong to different parent, but are on the same level. 

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>(); //Queue for storing the children
        Queue<TreeNode> pq=new LinkedList<>(); //Queue for recording their respective parents
        q.add(root); // Starting from the root node
        pq.add(null); //root node has no parent


        while(q!=null)
        {
            int size=q.size();
            boolean x_found=false;
            boolean y_found=false;
            TreeNode x_parent=null;
            TreeNode y_parent=null;

            //Level Processing is done here
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll(); //popping the first element in amongst the children
                TreeNode currP=pq.poll(); //popping its parent

                //checking if the popped node is the input value
                if(curr.val==x)
                {
                    x_found=true;
                    x_parent=currP;
                }

                //checking if the popped node is the input value
                if(curr.val==y)
                {
                    y_found=true;
                    y_parent=currP;
                }

            //if both x and y have same parent
            if(curr.left!=null && curr.right!=null)
            {
                if(curr.left.val==x && curr.right.val==y) return false;
                if(curr.left.val==y && curr.right.val==x) return false;
            }

            //adding the next nodes of the tree
                if(curr.left!=null)
                {
                    q.add(curr.left);
                    pq.add(curr);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                    pq.add(curr);
                }
            }

            //if x and y are found in the same level then we need to check if their parents are same
            if(x_found && y_found) return x_parent!=y_parent;
            //if x and y are found in different levels
            if(x_found || y_found) return false;
        }
return false;

    }
}


//DFS: We will do inorder traversal, maintain the height of the node to check if the level is same or different, and record the parent of x and y in separate variables

class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        if(root==null) return false;
        //x,y,depth,parent
        dfs(root,x,y,0,null);
        return x_depth ==y_depth && x_parent!=y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent)
    {
        //base
        if(root==null) return;
        //logic
        //store the depth and parent if the value is found
        

        //recurse through the left node
        dfs(root.left,x,y,depth+1,root);
        if(root.val==x)
        {
            x_depth=depth;
            x_parent=parent;
        }
        if(root.val==y)
        {
            y_depth=depth;
            y_parent=parent;
        }
        //recurse through the right node
        dfs(root.right,x,y,depth+1,root);
    } 
}