// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//BFS Approach
//O(n), O(n)
 List<int> result = new List<int>();
public IList<int> RightSideView(TreeNode root) {

    if(root == null)
        
    Queue<TreeNode> queue = new Queue<TreeNode>();
    queue.Enqueue(root);

    while(queue.Count > 0)
    {
        int size = queue.Count;
        for(int i = 0; i < size; i++)
        {
            TreeNode node = queue.Dequeue();
            if(i == size - 1)
                result.Add(node.val);
            if(node.left != null)
                queue.Enqueue(node.left);
            
            if(node.right != null)
                queue.Enqueue(node.right);
        }
    } 
}


//DFS approach
//O(n), O(h)
 List<int> result = new List<int>();
public IList<int> RightSideView(TreeNode root) {
    
    if(root == null)
        return result;       
    dfs(root, 0);
    return result;
    
}
    
private void dfs(TreeNode node, int level)
{
    if(node == null)
        return;
    
    //logic
    //go to right side first, because we need right side view
    if(result.Count == level)
        result.Add(node.val);
    dfs(node.right, level + 1);
    dfs(node.left, level + 1);
}