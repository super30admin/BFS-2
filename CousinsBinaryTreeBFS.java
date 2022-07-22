//Time Complexity :O(n)
//Space Complexity:O(n)
//Amazon interview
//Using BFS://Time Complexity :O(n)
//Space Complexity:O(n)
//Amazon interview
//Using BFS: The BFS starts from root, Consider x and y if found then return false elese it should return true.It compares the root of tree with sub trees example consider the root as parent of same child it should compare the left and right child of the tree.Go into the loop again and check, if found it should return x and y else to remove the current element from queue treenode and loop continues and checks againg and again but here it will contiue it returns also then starts continue of the loop it wont go back if not found.
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
    if(root == null || x== y)return false;
       //BFS
    Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
    while(!q.isEmpty()){
        int size = q.size();
        boolean x_found = false;
        boolean y_found = false;
        
        for(int i=0;i<size;i++){
            TreeNode curr = q.poll();
            if(curr.val == x){
                x_found = true;
            }
            if(curr.val == y){
                y_found = true;
            }
            if(curr.left != null && curr.right != null){
                if(curr.left.val == x && curr.right.val == y) return false;
                if(curr.left.val == y && curr.right.val == x) return false;
            }
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        if(x_found == true && y_found == true) return true;
        if(x_found == true || y_found == true) return false;
    }
        return false;
    }
}
