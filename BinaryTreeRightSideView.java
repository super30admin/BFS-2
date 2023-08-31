//Using BFS : levelorder traversal
//Time complexity = O(n)
// Space complexity = O(n) 

class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0 ; i<size; i++){
                TreeNode curr = q.poll();
                if(i==size-1){
                    result.add(curr.val);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        
        }
        return result;
        }
        
}

// Using DFS
//Time complexity = O(n)
// Space complexity = O(h) stack space; recursion

//Starting from the lift sub tree first..
class Solution {
    List<Integer> result ;
    public List<Integer> rightSideView(TreeNode root) {
        result  = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        dfs(root,0);
        return result;

    }
    public void dfs(TreeNode root,int height)
    {
        if(root==null)
        {
            return;
        }
        else
        {
            if(height==result.size()) //add into result if its a new level
            {
                result.add(root.val);
            }
            else{
                result.set(height,root.val); //updating it everytime
            }
        }
        dfs(root.left,height+1);
        dfs(root.right,height+1);
       
    }
}



// Using DFS
//Time complexity = O(n)
// Space complexity = O(h) stack space; recursion

//Starting from the right sub tree..
class Solution {
    List<Integer> result ;
    public List<Integer> rightSideView(TreeNode root) {
        result  = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        dfs(root,0);
        return result;

    }
    public void dfs(TreeNode root,int height)
    {
        if(root==null)
        {
            return;
        }
        else
        {
            if(height==result.size()) //add into result only if its a new level
            {
                result.add(root.val);
            }
        }
        dfs(root.right,height+1);
        dfs(root.left,height+1);
    }
}



