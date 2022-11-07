// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    //Approach2 DFS
    int levelX;
    int levelY;
    TreeNode parentX;
    TreeNode parentY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x,y,0,null);
        if(parentX!=parentY && levelX==levelY){
            return true;
        }
        return false;
    }

    public void dfs(TreeNode root, int x, int y, int level, TreeNode parent){
        //base
        if(root == null) return;

        //logic do it with inorder, postorder
        if(root!=null && root.val == x){
            parentX = parent;
            levelX = level+1;
        }

        if(root!=null && root.val == y){
            parentY = parent;
            levelY = level+1;
        }

        dfs(root.left,x,y,level+1,root);
        dfs(root.right,x,y,level+1,root);
    }

    //Approach1 BFS 
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     Queue<TreeNode> q = new LinkedList<>();
    //     List<Integer> parent = new ArrayList<>();
    //     List<Integer> levels = new ArrayList<>();
    //     int level = 0;
    //     if(root == null) return false;
    //     q.add(root);
    //     if(root.val == x || root.val == y) {
    //         parent.add(root.val);
    //         levels.add(level);
    //     }
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         for(int i=0;i<size;i++){
    //             TreeNode node = q.poll();
    //             if(node.left!=null)q.add(node.left);
    //             if(node.left!=null && (node.left.val == x || node.left.val == y)){
    //                 parent.add(node.val);
    //                 levels.add(level+1);
    //             } 
    //             if(node.right!=null)q.add(node.right);
    //             if(node.right!=null && (node.right.val == x || node.right.val == y)){
    //                 parent.add(node.val);
    //                 levels.add(level+1);
    //             } 
    //             if(size-1==i)level++;
    //         }
    //     }
    //     System.out.println("parent1"+ parent.get(0)+"parent2"+parent.get(1)+"level1"+levels.get(0)+"level2"+levels.get(1));
    //     if(parent.get(0)!=parent.get(1)  && levels.get(0)==levels.get(1)){
    //         return true;
    //     }
    //     return false;
    // }
}