
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    // BFS Approach using queue
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null)
            return new ArrayList<>();
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> result=new ArrayList<>();
        while(!queue.isEmpty())
        {
            List<Integer> currLevel=new ArrayList<>();
            int currSize=queue.size();
            
            for(int i=0;i<currSize;i++)
            {
                 TreeNode currNode=queue.poll();
                currLevel.add(currNode.val);
                if(currNode.left!=null)
                    queue.add(currNode.left);
                if(currNode.right!=null)
                    queue.add(currNode.right);
            }
            result.add(currLevel.get(currLevel.size()-1)); // adding last element in every currlevel list to result to get right side view
            
        }
        return result;
    }
   
    // DFS USING Recursion
      public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null)
            return new ArrayList<>();
          
          List<Integer> result=new ArrayList<>();
    
           helper(root,0,result);
          
          return result;
      }
    
    private void helper(TreeNode root,int depth, List<Integer> result)
    {
        if(root==null)
            return;
        
        // we can use if and else condition if we do dfs from left and then right.
        //if we do dfs right and left only if is required coz we are storing only right val nodes and if no right is available then we store left 
        
        if(depth==result.size())
            result.add(root.val); // new level and 1st insertion at that level
        else
            result.set(depth,root.val); // if new rightmost is found at level
        
        
        helper(root.left,depth+1,result);
        helper(root.right,depth+1,result);
           
    }
    
}