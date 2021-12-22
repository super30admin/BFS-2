//time o(n)
//space o(n)

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
    class Pair {
        int depth;
        int parent;
        
        public Pair(int depth, int parent) {
            this.depth = depth;
            this.parent = parent;
        }
        
        public int getDepth() {
            return this.depth;
        }
        
        public int getParent() {
            return this.parent;
        }
        
        public void setDepth(int depth) {
            this.depth = depth;
        }
        
        public void setParent(int parent) {
            this.parent = parent;
        }
    }
    Pair xVal = new Pair(0,0);
    Pair yVal = new Pair(0,0);
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        
        if(root.val == x || root.val == y)
            return false; 
        
        helper(root, null, x, y, 0);
        
        if((xVal.depth == yVal.depth) && (xVal.parent != yVal.parent)) {
            return true;
        } else {
            return false;
        }
        
    }
    
    public void helper(TreeNode root, TreeNode parent, int x, int y, int depth) {
        
        if(root == null) {
            return;
        }
        
        if(root.val == x) {
            xVal.setDepth(depth);
            xVal.setParent(parent.val);
        } else if(root.val == y) {
            yVal.setDepth(depth);
            yVal.setParent(parent.val);
        }
        
        helper(root.left, root, x,y,depth+1);
        helper(root.right, root, x,y,depth+1);
        
        
        
        
        
        
        
        
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         int level = 0;
//         while(!q.isEmpty()) {
//             int size = q.size();
//             level += 1;
//             for(int i=0; i<size; i++) {
//                 TreeNode temp = q.poll();
//                 if(temp.val == val) {
                    
//                 }
//                 if(temp.left!=null)
//                     q.add(temp.left);
//                 if(temp.right!=null)
//                     q.add(temp.right);
//             } 
//         }
        
        
    }
}
