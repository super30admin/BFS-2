// Time Complexity: O(n)
// Space Complexity: O(h)

class Solution {
    int[] li;

    public boolean isCousins(TreeNode root, int x, int y) {
        li = new int[2];
        if (height(root, x) == height(root, y) && li[0] != li[1]) {
            System.out.println(li[0]);
            System.out.println(li[1]);
            return true;

        }
        return false;

    }

    private int height(TreeNode root, int value) {
        // base
        if (root == null)
            return -1000;

        // logic
        if (root.val == value)
            return 0;

        int heightLeft = height(root.left, value);
        int heightRight = height(root.right, value);

        if (heightLeft == 0) {
            if (li[0] == 0)
                li[0] = root.val;
            else
                li[1] = root.val;
        }

        if (heightRight == 0) {
            if (li[0] == 0)
                li[0] = root.val;
            else
                li[1] = root.val;
        }
        return 1 + Math.max(heightLeft, heightRight);

    }
}