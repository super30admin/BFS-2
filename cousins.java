//time complexity O(n)
//space complexity O(h)is the height of the tree
//APPROACH: DFS

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
    int x_depth;
    int y_depth;
    TreeNode xParent = null;
    TreeNode yParent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return x_depth == y_depth && xParent != yParent;
    }

    private void dfs(TreeNode root, int x, int y , int depth, TreeNode parent){
        //base
        if(root == null) return;

        if(root.val == x){
            x_depth = depth;
            xParent = parent;
        }
        if(root.val == y){
            y_depth = depth;
            yParent = parent;
        }

        //logic
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}

//time complexity O(n)
//space complexity O(n/2) max size of the queue
//APPROACH: BFS

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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean xFound = false;
            boolean yFound = false;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(xFound && yFound) return true;
        }
        return false;
    }
}
