

// Solution 1 => DFS

/**
 * Time Complexity: O(n) since we process every node
 * Space Complexity: O(h) where h is height of the tree
 */

class Solution {

    private int x_level;
    private int y_level;

    private TreeNode x_parent;
    private TreeNode y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);

        if(x_level != y_level){
            return false;
        }

        return x_parent.val != y_parent.val;
    }

    private void helper(TreeNode root, int x, int y, int level, TreeNode parent){
        // base condition
        if(root == null){
            return;
        }

        // logic

        // we would process root first and check if its value is equal to x and y
        // if yes we would store found boolean abd parent
        if(root.val == x){  
            x_level = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }

        // conditional call i.e if any one of the parent is not found only then move forward
        if(x_parent == null || y_parent == null){
            helper(root.left, x, y, level + 1, root);
        }

        if(x_parent == null || y_parent == null){
            helper(root.right, x, y, level + 1, root);
        }
   
    }
}

// Solution 2 => BFS

/**
 * Time Complexity: O(n) since we process every node
 * Space Complexity: O(n / 2) = O(n) since max nodes would be at last level 
 */


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            boolean x_found = false;
            boolean y_found = false;

            for(int i = 0 ; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null && curr.right != null){ // check if immediate childern of current node are x and y
                    if(curr.left.val == x && curr.right.val == y){ // if yes, return false
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x){
                        return false;
                    }
                }

                if(curr.val == x){   // check if curr node is equal to x
                    x_found = true;
                }
 
                if(curr.val == y){  // check if curr node is equal to y
                    y_found = true;
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }

            }

            // once level iteration is done and if both are found, we return true as on same level and different parent 
            // (because if parent would have been same we would have returned earlier)
            if(x_found && y_found){ 
                return true;
            }

            // if only one node is found and we are done with level, so return false;
            if(x_found || y_found){
                return false;
            }
        }

        return false;
    }
}