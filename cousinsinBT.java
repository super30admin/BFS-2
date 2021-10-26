//TC:O(n)
//SC:O(n)
//Successfully ran on leetcode
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
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null)
            return false;

        Queue<Pair<TreeNode, Integer>> q=new LinkedList<>();
        q.add(new Pair<TreeNode, Integer>(root,-1));

        //BFS
        while(!q.isEmpty())
        {
            int size=q.size();

            int parentX=-1, parentY=-1;

            for(int i=0;i<size;i++)
            {
                Pair<TreeNode, Integer> front=q.poll();

                TreeNode node=front.getKey();
                int parent=front.getValue();

                if(node.val==x)
                    parentX=parent;
                else if(node.val==y)
                    parentY=parent;

                if(node.left!=null)
                {
                    q.add(new Pair<TreeNode,Integer>(node.left, node.val));
                }
                if(node.right!=null)
                {
                    q.add(new Pair<TreeNode, Integer>(node.right, node.val));
                }

            }

            if(parentX!=-1 && parentY!=-1 && parentX!=parentY)
                return true;
            else if(parentX!=-1 || parentY!=-1)
                return false;
        }
        return false;
    }
}
