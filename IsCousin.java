// Time Complexity : O(n)
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class IsCousin {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        private int level1;
        private int level2;
        private TreeNode parent1;
        private TreeNode parent2;
        public boolean isCousins(TreeNode root, int x, int y) {
            helper(root, x, y,null, 0);
            return level1 == level2 && parent1 != parent2;
        }
        private void helper(TreeNode root, int x, int y,TreeNode parent, int level){
            if(root == null) return;
            if(root.val == x){
                level1 = level;
                parent1 = parent;
            }else if(root.val == y){
                level2 = level;
                parent2 = parent;
            }
            helper(root.left, x, y,root, level+1);
            helper(root.right, x, y,root, level+1);
        }
    }
// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         if(root.left != null && root.right != null){
//             if((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)) return false;
//         }
//         while(!queue.isEmpty()){
//             boolean x_found = false;
//             boolean y_found = false;
//             int size = queue.size();
//             for(int i = 0; i < size; i++){
//                 TreeNode node = queue.poll();
//                 if(node.val == x) x_found = true;
//                 else if(node.val == y) y_found = true;
//                 if(node.left != null && node.right != null){
//                    if((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) return false;
//                 }
//                 if(node.left != null) queue.add(node.left);
//                 if(node.right != null) queue.add(node.right);
//             }
//             if(x_found && y_found) return true;
//             if(x_found || y_found) return false;
//         }
//         return false;
//     }
    
// }
