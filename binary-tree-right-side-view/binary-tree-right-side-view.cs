/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<int> RightSideView(TreeNode root) {
       
    List<int> list = new List<int>();
        RightSideDFS(root,1,list);
        return list;
        
    }
    
    private void RightSideDFS(TreeNode node,int depth, List<int> list)
    {
        if(node==null)
        {
            return ;
        }
        if(list.Count<depth)
        {
            list.Add(node.val);
        }
        RightSideDFS(node.right,depth+1,list);
        RightSideDFS(node.left,depth+1,list);
    }
}
