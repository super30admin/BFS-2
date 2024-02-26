//BFS approach
// Time Complexity : O(n), going over all the nodes
// Space Complexity : O(n), there will be n/2 nodes in the queue at leaf level
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Do BFS and insert the last element of that level to the result. 

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
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            //process the level
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(i == size-1){ // last element of the level
                    result.add(curr.val);
                }

                //process the childern
                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }

        return result;
    }
}

// DFS approach
// Time Complexity : O(n), going over all the nodes
// Space Complexity : O(h), recursive stack space
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Do DFS and maintain a level at each node, if the value of that level does not
// exist in result, add it. Replace all the value when moving right and same level is encountered.

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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root ,  int level){
        //base case
        if(root == null) return;

        if(level == result.size()){ // we need to add an entry for that level
            result.add(root.val);
        }
        else{
            result.set(level,root.val); // update the existing value
        }

        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}