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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(null == root) return result;
        // bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode currNode = queue.poll();
                if(null != currNode.left)
                {
                    queue.add(currNode.left);
                }
                if(null != currNode.right)
                {
                    queue.add(currNode.right);
                }
                if(size - 1 == i)
                {
                    result.add(currNode.val);
                }
            }
        }
        return result;

        // // dfs
        // helper(root, 0, result);
        // return result;
    }

//     private void helper(TreeNode root, int level, List<Integer> result)
//     {
//         // base
//         if(null == root) return;

//         // logic
//         if(level == result.size())
//         {
//             result.add(root.val);
//         }
//         helper(root.right, level+1, result);
//         helper(root.left, level+1,  result);
//     }
}