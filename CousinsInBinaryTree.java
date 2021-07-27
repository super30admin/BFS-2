// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean xFound = false;
        boolean yFound = false;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();

                if(temp.val == x) xFound = true;

                if(temp.val == y) yFound = true;

                // return false if x and y are siblings
                if(temp.left != null && temp.right != null) {
                    int val1 = temp.left.val;
                    int val2 = temp.right.val;

                    if((val1 == x && val2 == y) || (val2 == x && val1 == y))
                        return false;
                }

                if (temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }

            if(xFound && yFound) return true;
            if(xFound || yFound) return false;

        }
        return false;

    }
}