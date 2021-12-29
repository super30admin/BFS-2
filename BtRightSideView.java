//Time Complexity: O(n)
//Space Complexity: O(n)
//BFS
public class BtRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                TreeNode curr = q.poll();
                if(i == size-1)
                    result.add(curr.val);
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
        }
        
        return result;
    }
}


//Time Complexity: O(n)
//Space Complexity: O(n)
// DFS
public class BtRightSideView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
    
        dfs(root, 0);        
        return result;
    }
    
    
    private void dfs(TreeNode root, int level)
    {
        if(root == null)
            return;
        
        if(result.size() == level)
            result.add(root.val);
        
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}