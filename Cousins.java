/**
Time complexity: O(n)
Space complexity: O(n)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/
class Solution {
    /**
    Approach:
    - This is a BFS solution.
    - Create a queue and maintain a size variable because we need this to decide what happens when the level 
      changes in the tree.
    - Check if the given x and y are children of the same parent. If yes, return false.
    - Add the current node's left and right to the queue if they are not null.
    - In the end, if both x and y are found, return true. Else, false.
    */
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false, y_found = false;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    x_found = true;
                }
                if(curr.val == y) {
                    y_found = true;
                }
                if(curr.left != null && curr.right != null) {
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(x_found && y_found) {
                return true;
            }
            if(x_found || y_found) {
                return false;
            }
        }
        return false;
    }
}
