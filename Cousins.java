//Time complexity:O(n)
//Space complexity:O(Max breadth)
//Code ran on leetcode:Yes
//Solution with approach:Making a pair at every node of ts parent and current node
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
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        if(root==null)
            return false;
        q.add(new Pair<TreeNode,Integer>(root,-1));
        int parentx=-1;
        int parenty=-1;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Pair<TreeNode, Integer> pair= q.poll();
                TreeNode n = pair.getKey();
                int parent=pair.getValue();
                if(n.val==x){parentx=parent;}
                if(n.val==y){parenty=parent;}
                if(n.left!=null) {q.add(new Pair<TreeNode,Integer>(n.left,n.val));}
                if(n.right!=null) {q.add(new Pair<TreeNode,Integer>(n.right,n.val));}
              
                
            }
            if((parentx!=-1 && parenty!=-1)&&(parentx != parenty) )
                return true;
            else if(parentx==-1 && parenty!=-1 || parentx!=-1 && parenty==-1)
                return false;
        }
        return false;
        
    }

}
