// Time Complexity : O(n) where n is the number of nodes (DFS)
// Space Complexity : O(h) where h is the height of tree (DFS)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


//Method 3 - Using DFS - traversing on left side first
//TC: O(n) and SC: O(h) where n is the number of nodes and height is height of tree
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

        if(root == null)
            return result;

        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root , int depth , List<Integer> result){

        //base case
        if(root == null)
            return;

        //logic
        if(depth == result.size()){
            result.add(root.val);
        }
        else{
            result.set(depth,root.val);
        }

        dfs(root.left,depth+1,result);
        dfs(root.right,depth+1,result);

    }
}

//Method 2 - USing DFS - traversing on right side first
//TC: O(n) and SC: O(h) where n is the number of nodes and height is height of tree
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

        if(root == null)
            return result;

        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root , int depth , List<Integer> result){

        //base case
        if(root == null)
            return;

        //logic
        if(depth == result.size()){
            result.add(root.val);
        }

        dfs(root.right,depth+1,result);
        dfs(root.left,depth+1,result);
    }
}

//Method 1 - BFS
//TC: O(n) and SC: O(n) where n is the number of nodes in the tree
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

        //null check
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            //System.out.println(size);


            for(int i = 0; i < size ; i++){
                TreeNode curr = q.poll();
                //System.out.println(q.size());

                if(i == size-1){
                    result.add(curr.val);
                }

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

