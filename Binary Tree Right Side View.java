binary-tree-right-side-view



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
     List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {       
        if(root==null) return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                
                if(i ==size-1){
                    list.add(curr.val);
                }
                
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
           
            }
        return list;
        }
       /* 
       
       DFS approach
       dfs(root,0);
        return list;        
    }
    
    
    private void dfs(TreeNode root, int level){
        
        if(root==null) return;
        if(list.size() == level){
            list.add(root.val);
        }
        
        dfs(root.right,level+1);
        dfs(root.left,level+1);