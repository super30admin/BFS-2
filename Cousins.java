// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

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
        
        Queue<TreeNode> q = new LinkedList();
            q.add(root);
        while(!q.isEmpty()){
            int nodesthislevel = q.size(); //check the length of the queue for every level and process
            boolean foundx=false;
            boolean foundy=false;
            int xparent=-1;
            int yparent=-1;
            
            for(int i = 0; i < nodesthislevel; i++){
                TreeNode p = q.poll(); // remove the head to process it's children
                
                TreeNode left = p.left; // check forLeft
                    if(left!=null){
                        q.add(left);
                        if(left.val==x){
                            foundx=true;
                            xparent=p.val;
                        }else if(left.val==y){
                            foundy=true;
                            yparent=p.val;
                        }
                    }
                
                TreeNode right = p.right; // check for right
                    if(right!=null){
                        q.add(right);
                        if(right.val==x){
                            foundx=true;
                            xparent=p.val;
                        }
                        else if(right.val==y){
                            foundy=true;
                            yparent=p.val;
                        }
                    }
            }

            if(foundx==foundy && yparent != xparent){ // if both x and y don't have same parents return true
                return true;
            }        
        }
        return false;
    }
}

//Time Complexity: O()
//Space complexity: O()
class Solution {
    int parent;
    int depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        return dfs(root, new TreeNode(-1), 0, x, y);
    }
    
    private boolean dfs(TreeNode node,TreeNode prev, int dep, int x, int y) {
        if(node == null) return false;
        // Early stopping.
        if(parent != 0 && dep > depth) return false;
        if(node.val == x || node.val == y) {
            if(parent == 0) {
                parent = prev.val;
                depth = dep;
                return false;
            } else {
                if(parent != prev.val && dep == depth) return true;
                else return false;
            }
        }
        
        return dfs(node.left, node, dep + 1, x, y) || dfs(node.right, node, dep + 1, x, y);
    }
}