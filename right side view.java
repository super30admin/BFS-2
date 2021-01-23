///////////////////////////////////////////////DFS//////////////////////////////////////////////////////////////////

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    //result array 
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        //call dfs with level 0
        dfs(root,0);
        return res;
    }
    
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        //if the result array size is the same as the level that means you haven't been in this level so add to array with new entry
        if(res.size() == level){
            res.add(root.val);
        }
        //call dfs right first because we want right side view. if we wanted left side view we would do left dfs first.
        dfs(root.right, level+1);
        //call dfs left
        dfs(root.left, level+1);
    }
}

///////////////////////////////////////////////BFS//////////////////////////////////////////////////////////////////


//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no


//Your code here along with comments explaining your approach
/**

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
    //result array 
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        //create a queue
        Queue<TreeNode> que = new LinkedList<>();
        //add the root in
        que.add(root);
        //start while loop to start iterating level by level after adding
        while(!que.isEmpty()){
            //take the size of the current queue because that is the size of the current level
            int size = que.size();
            //loop until you find the last element in the current level for the right side view
            for(int i = 0; i < size; i++){
                //take the current element and pop it out of the queue
                TreeNode cur = que.poll();
                //find the last element in the level
                if(i == size - 1) {
                    res.add(cur.val);
                }
                //now check if there is left and right and add it to the queue
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
        }
        return res;
    }
}
