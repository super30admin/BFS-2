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
// BFS
// TC: O(N) -> N nodes of the tree
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if ( root == null )
//             return false;
      
//         Queue<TreeNode> q = new LinkedList();
//         q.add(root);
//         while (!q.isEmpty())
//         {
//            int size = q.size();
//            boolean x_found = false;
//            boolean y_found = false;
//            for (int i = 0; i < size; i++)
//            {
//                TreeNode cur = q.poll();
//                 if (cur.val == x)
//                    x_found = true;
//                 if (cur.val == y)
//                    y_found = true;
//                if (cur.left != null && cur.right!=null)
//                {
//                    if (cur.left.val == x && cur.right.val == y || cur.left.val == y && cur.right.val == x) 
//                               return false;
//                }
//                if (cur.left != null)
//                    q.add(cur.left);
//                if (cur.right != null)
//                    q.add(cur.right);
               
//            }
//            if (x_found && y_found)
//                return true;
//            if (x_found || y_found)
//                return false;
            
//         }
//         return false;
//     }
// }


// DFS
// TC: O(N) -> N nodes of the tree
// SC: O(H) -> H height of the tree
// Did it run successfully on Leetcode? : Yes

class Solution {
    TreeNode x_parent, y_parent;
    int x_height, y_height;
    public boolean isCousins(TreeNode root, int x, int y) {
        if ( root == null )
            return false;
        dfs(root, 0, null, x, y);
        return (x_parent != y_parent && x_height == y_height);
    }
    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y)
    {
        //base
        if ( root == null)
            return;
        //logic
        if (root.val == x)
        {
            x_height = level;
            x_parent = parent;
        }
        if (root.val == y)
        {
            y_height = level;
            y_parent = parent;
        }
        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);
    }
}

