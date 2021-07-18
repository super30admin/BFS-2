package BFS2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*S30 Big N Problem #60 {Medium} - https://www.youtube.com/watch?v=C1WO6NTfChI
    You are given a binary tree and think you are standing on the right side of it, you have to return the values of the nodes that can be seen from the right and these should be ordered from top to bottm

            Example:

            Input: [11,2,3,null,5,null,4]

            Output: [11, 3, 4]

            Explanation:
                             11            <---
                            /  \
                           2    3         <---
                            \    \
                             5    4       <---
            Source Link: https://leetcode.com/problems/binary-tree-right-side-view/

                -------------------------------------------------------------------------------------------------------
                Time complexity : BFS -O(N) , DFS - O(N)
                space complexity: BFS- O(N) , DFS - O(H)
                Did this code run successfully in leetcode : yes
                problems faces : no*/

//--------------------------------BFS-----------------------
public class BinaryTreeRightSideView {
    
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                if(i== size-1)
                {
                    result.add(curr.val);
                }
                
                if (curr.left != null)
                    q.add(curr.left);
                
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return result;
    }
    
    //------------------DFS from right recursive calls----------------------------------
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideViewWithDFS(TreeNode root) {
        
       
        if(root == null) return result;
        dfsRight(root,0);
        return result;
    }
    
    private void dfsRight(TreeNode root,int level)
    {
        if(root == null ) return;
        
        //logic
        if(result.size() == level)
        {
           result.add(root.val);
        }
        dfsRight(root.right,level+1);
        dfsRight(root.left,level+1);
    }
    
    //------------------DFS from left recursive calls----------------------------------
   // List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideViewWithleftRecursiveDFS(TreeNode root) {
        
       
        if(root == null) return result;
        dfsLeft(root,0);
        return result;
    }
    
    private void dfsLeft(TreeNode root,int level)
    {
        //base
        if(root == null ) return;
        
        //logic
        if(result.size() == level)
        {
           result.add(root.val);
        }else {
            result.set(level, root.val);
        }
       
        dfsLeft(root.left,level+1);
        dfsLeft(root.right,level+1);
    }

}
