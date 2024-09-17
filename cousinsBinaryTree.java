/* 993. Cousins in Binary Tree
Two Nodes are cousins if they have the same depth but different parents

Depth first search
Time Complexity: O(n)
Space Complexity: O(h) at max there are only height number of elements in the stack
*/

class Solution {
    TreeNode parentOfx = null;
    TreeNode parentOfy = null;

    int x_depth = -1, y_depth = -1;

    public boolean isCousins(TreeNode root, int x, int y) {

        helper(root, x, y, 0, null); // 0 is the depth of the root and null is the parent of root

        return x_depth == y_depth && parentOfx != parentOfy;
    }

    private void helper(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null)
            return;

        if(root.val == x){
            x_depth = depth;
            parentOfx = parent;
        }

        if(root.val == y){
            y_depth = depth;
            parentOfy = parent;
        }

        helper(root.left, x, y, depth+1, root);
        helper(root.right, x, y, depth+1, root);
    }
}

/* 993. Cousins in Binary Tree
Two Nodes are cousins if they have the same depth but different parents

Breadth first search -- make use of level order traversal
Time Complexity: O(n)
Space Complexity: O(n) // at max the width of the tree
*/

class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            // for each level maintain this
            boolean xFound = false, yFound = false;

            // for loop to go over the elements at each level
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