// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS: We can do level order traversal and at every level we can take the last element
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result=new ArrayList<>(); // Stores the final result
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root); //Stores the root node

        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(i==size-1)   // add the last node of the current level
                {
                    result.add(curr.val);
                }

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }

                if(curr.right!=null)
                {
                    q.add(curr.right);
                }

            }
        }

return result;
    }
}


//DFS Approach 1: We add the right nodes in the array, if an element is already present in the array, then we don't add anything, if not, then we add the current right node.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result=new ArrayList<>(); // Stores the final result
        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root,int level,List<Integer> result)
    {
        //base
        if(root==null) return;

        //logic
        if(result.size()==level)
        {
            result.add(root.val);
        }

        dfs(root.right,level+1,result);
        dfs(root.left,level+1,result);

    } 
}



//DFS Approach 2: We will go from left to right. Here we will check if the value is already present in that level, if yes then we override it with the value in the right node.
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result=new ArrayList<>(); // Stores the final result
        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root,int level,List<Integer> result)
    {
        //base
        if(root==null) return;

        //logic
        if(result.size()==level)
        {
            result.add(root.val);
        }

        else
        {
            result.set(level,root.val);
        }

        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);

    } 
}