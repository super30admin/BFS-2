// Time Complexity :O(N)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root== null)
        return result;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size= q.size();

            for(int i=0; i<size;i++)
            {
                TreeNode curr = q.poll();

                if(i==size-1)
                result.add(curr.val);

                if(curr.left!=null)
                q.add(curr.left);

                if(curr.right!=null)
                q.add(curr.right);
            }
        }

        return result;


        //DFS 1.1

    //    helper(root,result,0);
    //     return result;
    // }

    // public void helper(TreeNode root,List<Integer> result,int size)
    // {
    //     if(root == null)
    //     return;

    //     if(size==result.size())
    //     result.add(root.val);

    //     else
    //     result.set(size,root.val);

    //     helper(root.left,result,size+1);
    //     helper(root.right,result,size+1);

        //DFS-1.2
        // if(root == null)
        // return;

        // if(result.size()==size)
        // result.add(root.val);

        // helper(root.right,result,size+1);
        // helper(root.left,result,size+1);
    }
}