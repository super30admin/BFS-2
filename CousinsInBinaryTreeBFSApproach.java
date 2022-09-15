// Time complexity: O(N)
// Space complexity: O(N)

// Approach: We run a BFS, we keep a flag xFound and yFound at every level. When we pop the element at the left, we check if the left child and right child are equal to x & y. If they are, then we return false are they have same parents and are not cousins. They are siblings. At the end of the level, we have another check to see if both xFound and yFound are true. This is the check to see if they are at the same level. If both are at the same level, xFound and yFound will be true. If they are at diff levels, then one if them will be false. This way we stop the BFS early.

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xFound = false; // flag to check if we found x at the current level
            boolean yFound = false; // flag to check if we found y at the current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.val == x) xFound = true; // if we found x, make flag true
                if (curr.val == y) yFound = true; // if we found y, make flag true
                
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) return false; // if x and y are children of the same parent, we return false as they are sublings and not cousins
                    if (curr.left.val == y && curr.right.val == x) return false; // if y and x are children of the same parent, we return false as they are sublings and not cousins
                }
                
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            if (xFound && yFound) return true; // this is the check to see if we found both at the same level, we return true
            if (xFound || yFound) return false; // if we only found 1, we return false as they are not at the same level in this case
        }
        return false;
    }
}