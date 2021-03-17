//Time complexity: O(n)
//Space complexity: O(height)
//Executed on leetcode.
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
    
    boolean output = false;
    int cousin1 = 0;
    int cousin2 = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return output;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        cousin1=x;
        cousin2=y;
        BFS(list);
        
        return output;          //Checking if each nodes childs at every level with the given 2 values.
    }
    void BFS(List<TreeNode> root)   //Returns true if found both the nodes at same level and not child of same node.
    {
        if(root.size()==0)
            return;
        
        List<TreeNode> temp = new ArrayList<>();
        boolean c1=false, c2 = false;
        for(int i=0;i<root.size();i++)
        {
            boolean c3= false;
            if(root.get(i).left!=null && (root.get(i).left.val==cousin1 || root.get(i).left.val==cousin2))
            { 
                c3 = true;
                
            }
            if(root.get(i).right!=null && (root.get(i).right.val==cousin1 || root.get(i).right.val==cousin2))
            {
                if(c3)
                {
                    return;
                }
                else
                    c3 = true;
            }
            if(!c1 && c3)
            {
                c1=true;
            }
            else if(c3)
                c2=true;
            if(c1&&c2)
            {
                output = true;
                return;
            }    
            if(root.get(i).left!=null)
                temp.add(root.get(i).left);
            if(root.get(i).right!=null)
                temp.add(root.get(i).right);
            
        }
        
        BFS(temp);
    }
}