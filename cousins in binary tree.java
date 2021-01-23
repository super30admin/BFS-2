/////////////////////////////////////////DFS/////////////////////////////////////////

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
        TreeNode xParent;
        TreeNode yParent;
        int xLevel;
        int yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        //have 4 integers 2 parents and 2 levels
        //start dfs with level 0
        dfs(root, null, 0, x, y);
        // System.out.println(xParent);
        // System.out.println(yParent);
        // check if the x and y parents are differet and same level
        return (xParent != yParent) && (xLevel == yLevel);
    }
    
    private void dfs(TreeNode root, TreeNode parentRoot, int level, int x, int y){
        //base
        if(root == null) return;
        //logic
        //check if the node we are at is one of the x or y then we just get its parent and level
        if(root.val == x){
            xParent = parentRoot;
            xLevel = level;
        }
        if(root.val == y){
            yParent = parentRoot;
            yLevel = level;
        }
        //go left and right
        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}


/////////////////////////////////////////BFS/////////////////////////////////////////


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        //create a queue 
        Queue<TreeNode> que = new LinkedList<>();
        //add the current root to the queue
        que.add(root);
        //set two booleans to see if you find the desired values in the level
        boolean xFound = false;
        boolean yFound = false;
        //start the while loop
        while(!que.isEmpty()){
            //take the size because we want to know which level we are on
            int size = que.size();
            //start the for loop to iterate that level
            for(int i = 0; i < size; i++){
                //take the current out of the queue
                TreeNode cur = que.poll();
                //if current equals one of the desired elements change to true
                if(cur.val == x) xFound = true;
                if(cur.val == y) yFound = true;
                //check if the current node's children are the x and y values if they are return false
                if(cur.left != null && cur.right != null){
                    if(cur.left.val == x && cur.right.val == y) return false;
                    if(cur.right.val == x && cur.left.val == y) return false;
                }
                //go check the left and right children and add to the queue
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
            //if xFound and yFound are true that means they are same level and not siblings otherwise our sibling check would've caused a false trigger
            if(xFound && yFound) return true;
            //if either or is found then return false
            if(xFound || yFound) return false;
        }
        return false;
    }
}
