package com.ds.rani.bfs;

import java.util.LinkedList;
import java.util.Queue;

//Approach: In DFS solution using  inorder recursion, I am maintaining depth at each level and its parent
//whenever I am getting root value equal to x value or y value I am storing xDepth and yDepth and xParent and yParent
//Finally I am just checking xParent and y parent should not be same but their depth should be same

//In BFS solution I am using queue to traverse it level by level by level and whenever i am getting x value for that level and y value also
//I am making xFound flag and yFound flag to true.
//Before adding left node and right node in queue I am checking x and y are not siblings

//BFS:
//Time Complexity:o(n) number of elements in the tree
//Space complexity:o(n/2)

//DFS:
//Time Complexity:o(n)
//Space complexity:o(h) recursive stack where h is height of the tree
public class CousinsInBinaryTree {

    /**
     * @param root
     * @param x
     * @param y
     * @return
     */
    int xDepth, yDepth;
    TreeNode xParent, yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
       // return bfs( root, x, y );
        dfs(root,x,y,0,null);
        return (xDepth==yDepth && xParent!=yParent);
    }


    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        //base case
        if (root == null)
            return;
        //logic
        if (root.val == x) {
            xDepth = depth;
            xParent = parent;
        }

        if (root.val == y) {
            yDepth = depth;
            yParent = parent;
        }

        //recursion
        dfs( root.left, x, y, depth + 1, root );
        dfs( root.right, x, y, depth + 1, root );

    }

    private boolean bfs(TreeNode root, int x, int y) {

        if (root == null)
            return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add( root );

        while (!q.isEmpty()) {
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x) xFound = true;
                if (curr.val == y) yFound = true;

                //parent should not be same
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x))
                        return false;
                }
                //Add left in queue
                if (curr.left != null)
                    q.add( curr.left );

                //Add right in queue
                if (curr.right != null)
                    q.add( curr.right );
            }

            //If x and y are found at same level then return true
            if (xFound && yFound)
                return true;
        }
        return false;
    }
}
