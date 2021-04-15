// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean foundx = false;
        boolean foundy = false;
        while (!q.isEmpty()) {
            int size = q.size();
            // loop untill all the elements in each level
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // check if you found the values x and y
                if (curr.val == x)
                    foundx = true;
                if (curr.val == y)
                    foundy = true;
                // if both elements are under the same root node return false
                if (curr.right != null && curr.left != null) {
                    if (curr.right.val == x && curr.left.val == y || curr.left.val == x && curr.right.val == y)
                        return false;
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
            }
            // if both are found return true since we are still in same level
            if (foundx && foundy)
                return true;
            // case when both are found but in different level
            if (foundx || foundy)
                return false;

        }
        // when the element itself is not present in tree return false
        return false;
    }
}