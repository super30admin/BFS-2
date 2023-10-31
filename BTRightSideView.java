// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BTRightSideView
{
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> ans = new ArrayList();

        if(root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            TreeNode temp = null;
            for(int i = 0; i< size; i++)
            {
                temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            ans.add(temp.val);
        }
        return ans;
    }

    //DFS
    List<Integer> ans = new ArrayList();
    public List<Integer> rightSideViewDFS(TreeNode root)
    {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode root, int level)
    {
        //base
        if (root == null)
            return;
        if(ans.size() <= level)
            ans.add(level, root.val);

        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}
