/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //Time Complexity: O(n)
 //Space Complexity: O(h)
public class Solution {
    List<int> result;
    public IList<int> RightSideView(TreeNode root) {
         if (root == null) return new List<int>();
            result = new List<int>();
            dfs(root, 0);
            return result;
    }
      private void dfs(TreeNode root, int lvl)
        {
            //base
            if (root == null) return;
            //logic
            if (lvl == result.Count)
            {
                result.Add(root.val);
            }
            dfs(root.right, lvl + 1);
            dfs(root.left, lvl + 1);
        }
}