class Solution {
    TreeNode xParent;
    TreeNode yParent;
    int xDepth;
    int yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        // if(root == null) {
        //     return false;
        // }

        // boolean xFound = false;
        // boolean yFound = false;

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     for(int i = 0; i < size; i++) {
        //         TreeNode node = q.poll();
        //         if(node.val == x) {
        //             xFound = true;
        //         }
        //         if(node.val == y) {
        //             yFound = true;
        //         }
                
        //         if(node.left != null && node.right != null) {
        //             if(node.left.val == x && node.right.val == y) {
        //                 return false;
        //             }
        //             if(node.left.val == y && node.right.val == x) {
        //                 return false;
        //             }
        //         }
        //         if(node.left != null) {
        //             q.add(node.left);
        //         }
        //         if(node.right != null) {
        //             q.add(node.right);
        //         }
        //     }
        //     if(xFound == true && yFound == true) {
        //         return true;
        //     }
        //     if(xFound == true || yFound == true) {
        //         return false;
        //     }
        // }
        // return true;

        // DFS Solution
        
        if(root == null) {
            return false;
        }
        xDepth = -1;
        yDepth = -1;
        dfs(root, 0, null, x, y);
        return (xParent != yParent) && (xDepth == yDepth);
    }

    private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y) {
        if(root == null || (xDepth != -1 && yDepth != -1)) {
            return;
        }

        dfs(root.left, depth + 1, root, x, y);
        dfs(root.right, depth + 1, root, x, y);

        if(root.val == x) {
            xParent = parent;
            xDepth = depth;
        }
        if(root.val == y) {
            yParent = parent;
            yDepth = depth;
        }
    }
}
