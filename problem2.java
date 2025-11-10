
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/* Approach
 * 
 * We are using the BFS approach 
 * traversing each level of the tree one by one
 * using and Queue to keep track of levels
 * 
 * while we are traversing the node, we check the value to find y or x and turn there flags ture if found
 * while traversing we also add the node of the next level in  the queue but while we add the 
 * nodes we check if the nodes parent is the same or not if they are we just return false
 * 
 * by the end of the traversal if we find both x and y we return true otherwise false
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            boolean xFound = false;
            boolean yFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode cur = nodes.poll();
                if (cur.val == x) {
                    xFound = true;
                }
                if (cur.val == y) {
                    yFound = true;
                }
                if (cur.left != null && cur.left.val == x && cur.right != null && cur.right.val == y) {
                    return false;
                }
                if (cur.left != null && cur.left.val == y && cur.right != null && cur.right.val == x) {
                    return false;
                }
                if (cur.left != null) {
                    nodes.add(cur.left);
                }
                if (cur.right != null) {
                    nodes.add(cur.right);
                }
            }
            if (xFound && yFound) {
                return true;
            }
            if (xFound || yFound) {
                return false;
            }
        }
        return false;
    }
}