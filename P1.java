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

//time-o(n)
//space-o(leaf nodes)- n/2- o(n)
//passed in leetcode- yes
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> result= new ArrayList<Integer>();
        
        if (root == null) return result;
        
        q.add(root);
        int level=0;
        
        while(!q.isEmpty())
        {
            int size = q.size(); // to keep track of which nodes to poll, coz we want to go level by level
            
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.remove();
                
                 if(level==result.size()) result.add(node.val); //add to result if not already added
                 else result.set(level,node.val); //if already added replace, since we want right most element
                
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
           level++;
            
        }
        
        return result;
}
}

//dfs
    
//time-o(n)
//space-o(h)
//passed in leetcode- yes
    
/*List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root==null) return result;
        dfs(root, 0);
        return result;
    }
    
    public void dfs(TreeNode node, int level)
    {
        if(node==null)
            return;
        
            if(level==result.size())
            {
                result.add(node.val);
            }
            result.set(level,node.val);
        
        dfs(node.left, level+1);
        dfs(node.right,level+1);
        
    }
*/

//bfs


/*    Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> result= new ArrayList<Integer>();
         if (root == null) return result;
        q.add(root);
        int level=0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.remove();
                 if(level==result.size()) result.add(root.val);
                 else result.set(level,root.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
           level++;
            
        }
        
        return result;
*/