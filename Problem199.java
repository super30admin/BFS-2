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
//BFS
// Time Complexity : O(n)  
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root==null) return result;
            queue.add(root);
            while(!queue.isEmpty())
            {
                int size = queue.size();
                for (int i=0;i<size;i++)
                {
                    TreeNode curr = queue.poll();
                    if(i==size-1){
                        result.add(curr.val);
                    }
                    
                    if(curr.left!=null) queue.add(curr.left);
                    if(curr.right!=null) queue.add(curr.right);
                    
                }
            }
        return result;
        }
        }


        // DFS
        // Time Complexity : O(n)  
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
        class Solution {
            List<Integer> result;
                public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
        }
        private void helper(TreeNode root,int height)
        {
            //base case
             if(root ==null) return;
             //logic
             if(height == result.size())
             {
                 result.add(root.val);
             }
             helper(root.right,height+1);
             helper(root.left, height+1);
        }
    }