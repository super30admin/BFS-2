/*
1. Approach: Depth first search using recursion
Time Complexity: O(N)
Space Complexity: O(H)
Successfully run on LeetCode: Yes
*/

class Solution {
    TreeNode parentOfx = null;
    TreeNode parentOfy = null;

    int x_depth = -1, y_depth = -1;

    public boolean isCousins(TreeNode root, int x, int y) {

        helper(root, x, y, 0, null); // 0 is the depth of the root and null is the parent of root

        return x_depth == y_depth && x_parent != y_parent;
    }

    private void helper(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null)
            return;

        if(root.val == x){
            x_depth = depth;
            x_parent = parent;
        }

        if(root.val == y){
            y_depth = depth;
            y_parent = parent;
        }

        helper(root.left, x, y, depth+1, root);
        helper(root.right, x, y, depth+1, root);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
Successfully run on LeetCode: Yes
2. BFS Approach using queue
*/

class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false, yFound = false;

            for(int i=0; i < size; i++){
                TreeNode cur = q.poll();

                if(cur.val == x) xFound = true;
                if(cur.val == y) yFound = true;

                if(cur.left != null && cur.right != null){
                    if(cur.left.val == x && cur.right.val == y) return false;
                    if(cur.left.val == y && cur.right.val == x) return false;
                }

                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            if(xFound && yFound)
                return true;
        }
        return false;
    }
} 