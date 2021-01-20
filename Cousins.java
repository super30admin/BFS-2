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
/*
method 2: recursive dfs approach
time complexity :O(n)
space complexity: O(h)

*/
class Cousins {
    
    TreeNode xparent, yparent;
    int xdepth;
    int ydepth;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)return false;
        
        dfs(root,null,0,x,y);
        return (xparent != yparent && xdepth == ydepth);
    }
    
    private void dfs(TreeNode node, TreeNode parent, int level, int x,int y){
        //base case
        if(node == null)return;
        
        //main logic
        if(node.val == x ){
            xparent = parent;
            xdepth = level;
        }
        if(node.val == y){
            yparent = parent;
            ydepth = level;
        }
        
        dfs(node.left, node, level+1, x, y);
        dfs(node.right, node, level+1, x, y);
    }
}



/*
method 1 = BFS approach
time complexity : O(n)
space complexity : O(n/2)

here, at every level we check the children of each node, if childer are x and y, return false as they are siblings not cousins
if both found at same level and their parent is not same then they are cousins, return true


*/
// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if(root == null)return false;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             boolean xfound = false;
//             boolean yfound = false;
//             for(int i = 0 ;i < size; i++){
//                 TreeNode node = queue.poll();
                
//                 if(node.val == x)xfound = true;
//                 if(node.val == y) yfound = true;
            
//                 if(node.left != null && node.left.val == x) {
//                     if(node.right != null && node.right.val == y){
//                         return false;
//                     }
//                 } 
//                 if(node.left != null && node.left.val == y) {
//                     if(node.right != null && node.right.val == x){
//                         return false;
//                     }
//                 }
                
//                 if(node.left != null) queue.add(node.left);
//                 if(node.right != null)queue.add(node.right);
                    
//             }
//             if(xfound && yfound)return true;
//             if(xfound || yfound)return false;
            
//         }
        
//         return true;
            
//     }
// }
