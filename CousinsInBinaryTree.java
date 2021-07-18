package BFS2;

import java.util.LinkedList;
import java.util.Queue;

/*S30 Big N Problem #61 {Easy} - https://www.youtube.com/watch?v=C1WO6NTfChI

You are given a binary tree and the root node is at depth 0. also children of each depth k node are at depth k+1. 
given the root and the values x and y of two nodes also it is given that the two nodes of a binary are cousins if they have the same depth, 
but have different parents. you have to return true if and only if the nodes correspondign to values x and y are cousins.
you may assume that:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Source Link: https://leetcode.com/problems/cousins-in-binary-tree/
    -------------------------------------------------------------------------------------------------------
    Time complexity : BFS -O(N) , DFS - O(N)
    space complexity: BFS- O(N) , DFS - O(H)
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class CousinsInBinaryTree {
    
public boolean isCousins(TreeNode root, int x, int y) {
    
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    
    
    while(!q.isEmpty())
    {
        int size = q.size();
        boolean foundOne = false;
        boolean foundTwo = false;
        
        for(int i=0;i<size;i++)
        {
            TreeNode node = q.poll();
          
            if(node.left != null && node.right != null && node.left.val == x  && node.right.val == y) return false;
            if(node.left != null && node.right != null && node.left.val == y  && node.right.val == x) return false;
            
             if(node.val == x)
            {
                foundOne = true;
            }
             if( node.val == y)
            {
                foundTwo = true;
            }
            
           if(node.left != null) q.add(node.left);
           if(node.right != null)q.add(node.right);
            
        }
        
        if(foundOne && foundTwo) return true;
        if(foundOne || foundTwo) return false;
    }
    
    return false;
    
}


//------------------------------------DFS---------------------------------------------


int x_depth =0;
int y_depth =0;
TreeNode xParent;
TreeNode yParent;

public boolean isCousinsWithDFS(TreeNode root, int x, int y) {
    
    dfs(root,x,y,0);
    
    if( xParent == null || yParent ==null ||   xParent == yParent) return false;
    if(x_depth == y_depth ) return true;
    
    return false;
}

private void dfs(TreeNode node,int x,int y,int level)
{
    //base
    if(node == null) return;
    //logic
    if (node.left != null && node.left.val == x) 
    {
        x_depth = level;
        xParent = node;
    }
    if (node.left != null && node.left.val == y) 
    {
        y_depth = level;
        yParent = node;
    }
    
    if (node.right != null && node.right.val == x) 
    {
        x_depth = level;
        xParent = node;
    }
    
    if (node.right != null && node.right.val == y) 
    {
        y_depth = level;
        yParent = node;
    }
    
    if(node.left != null) 
        dfs(node.left,x,y,level+1);
    
    if(node.right != null ) 
        dfs(node.right,x,y,level+1);
    
}

}
