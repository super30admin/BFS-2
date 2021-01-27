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
// DFS on right first, no need to replace some values of result again and again
// TC: O(N) - N: nodes of the tree
// SC: O(H) - H: height of the tree
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        if ( root == null)
        return result;
       dfs(root, 0);
       return result;      
    }
    private void dfs(TreeNode root, int level)
    {
        //base
        if ( root == null)
          return;
        //
        if (level == result.size())
           result.add(root.val);
        dfs(root.right, level+1);
        //stack.pop()
        dfs(root.left, level+1);
    }
}

// DFS on left first
// TC: O(N) -> N: nodes of the tree
// SC: O(H) -> H: height of the tree
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        if ( root == null)
        return result;
       dfs(root, 0);
       return result;      
    }
    private void dfs(TreeNode root, int level)
    {
        //base
        if ( root == null)
          return;
        //
        if (level == result.size())
           result.add(root.val);
        else
            result.set(level, root.val);
        dfs(root.left, level+1);
        //stack.pop()
        dfs(root.right, level+1);
    }
}

//BFS
// TC: O(N)
// SC: O(N) -> O(N/2) -> max
 class Solution {
public List<Integer> rightSideView(TreeNode root) {
       if ( root == null)
        return new ArrayList();
      List<Integer> result = new ArrayList();
       Queue<TreeNode> q = new LinkedList();
       q.add(root);
     while (!q.isEmpty())
     {
         int size = q.size();
         for ( int i = 0; i < size; i++)
         {
            TreeNode node = q.poll();
             // add only node at end of the queue to the result (right view). For left view, make check (i == 0), then add node.val to result
            if (i == size-1)
              result.add(node.val);
            if (node.left != null)
                 q.add(node.left);
            if (node.right != null)
                 q.add(node.right);
         }
     }
    return result;
   }
 }
