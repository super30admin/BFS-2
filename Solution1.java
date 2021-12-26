// Time Complexity :O(n) touching all nodes once
// Space Complexity :O(n/2) maximum number of lements in a queue at one time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        
        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            // we need size variable to maintain levels but add only the last element of each level
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(i==size-1){
                    result.add(temp.val);
                }
                
                if(temp.left!=null)
                    q.add(temp.left);
                
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }

        return result;
    }

    // DFS

    // Time Complexity :O(n) touching all nodes once
// Space Complexity :O(n/2) maximum number of elements in a recursive stack at one time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    List<Integer> result1;
    public List<Integer> rightSideView1(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        result1= new ArrayList<>();
        
        dfs(root,0);
        return result1;      
    }
    
    private void dfs(TreeNode root, int level){
        
        // base
        if(root==null)
            return;
        
        //logic
        if(level==result1.size())
            result1.add(root.val);
        else
            result1.set(level,root.val);
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}