//Time Complexity: O(n)
//Space Complexity: O(n)
//running on leetcode: yes
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //base case
        if (root==null)
        {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        //BFS Approach
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                if (i==size-1)
                {
                    result.add(curr.val);
                }
                if (curr.left != null)
                {
                    q.add(curr.left);
                }
                if (curr.right != null)
                {
                    q.add(curr.right);
                }
            }
        }
        return result;
        
    }
}
