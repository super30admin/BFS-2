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

// Defination of cousins here is - same level but not same root
// This indicates BFS
// TC : O(n)
// SC : O(n)
// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
//         Queue<TreeNode> q = new LinkedList<>();
//         Queue<TreeNode> pq = new LinkedList<>(); // parent queue to maintain parrent values 
//         q.add(root);
//         pq.add(null);
//         while(!q.isEmpty()){
//             int size = q.size();
//             boolean xf= false; TreeNode xp = null;
//             boolean yf = false; TreeNode yp = null;
//             for(int i=0;i<size;i++){
//                 TreeNode curr = q.poll();
//                 TreeNode pcurr = pq.poll();
//                 if(curr.val==x){
//                     xf= true;
//                     xp = pcurr;
//                 }
//                 if(curr.val==y){
//                     yf= true;
//                     yp = pcurr;
//                 }
//                 if(curr.left!=null){
//                     q.add(curr.left);
//                     pq.add(curr);
//                 }
//                 if(curr.right!=null){
//                     q.add(curr.right);
//                     pq.add(curr);
//                 }
//             }
//             if(xf && yf) return xp!=yp;
//             if(xf || yf) return false;
//         }
//         return false;
//     }
// }

// Now i want to elinmate the SC 
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode xp = null;
            TreeNode yp = null;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && curr.left.val==x){
                    xp = curr;
                }
                if(curr.right!=null && curr.right.val==x){
                    xp = curr;
                }
                if(curr.left!=null && curr.left.val==y){
                    yp = curr;
                }
                if(curr.right!=null && curr.right.val==y){
                    yp = curr;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(xp!=null && yp!=null) return xp!=yp;
            if(xp!=null && yp!=null) return false;
        }
        return false;
    }
}