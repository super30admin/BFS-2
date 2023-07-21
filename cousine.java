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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean xFlag = false;
            boolean yFlag = false;
            int size = q.size();
            
            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.val ==x) xFlag=true;
                if(curr.val ==y) yFlag=true;

                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val ==y) return false;
                    if(curr.left.val==y && curr.right.val ==x) return false;

                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
                if(xFlag && yFlag) return true;
                if(xFlag || yFlag) return false;
        }
        return false;
    }
}



// class Solution {
//     TreeNode xParent;
//     TreeNode yParent;
//     int xht;int yht;
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if(root==null) return false;
//         dfs(root,null,0,x,y);
//         return xht==yht && xParent!=yParent;
//     }
//     private void dfs(TreeNode root, TreeNode parent, int level,int x, int y){
//         if(root==null) return;

//         if(root.val==x){
//             xParent=parent;
//             xht = level;
//         }

//         if(root.val==y){
//             yParent=parent;
//             yht = level;
//         }

//         if(yParent==null || xParent==null)
//             dfs(root.left, root, level+1, x,y);

//         if(yParent==null || xParent==null)
//             dfs(root.right, root, level+1, x,y);
//     }
// }