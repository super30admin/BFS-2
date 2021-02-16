// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public boolean isCousins(TreeNode root, int A, int B) {

        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean isAexist = false;		
            boolean isBexist = false;	

            for (int i = 0; i < size; i++) {

                TreeNode cur = queue.poll();

                // check if curr node val is A or B
                if (cur.val == A) isAexist = true;
                if (cur.val == B) isBexist = true;

                // check for its children that our x&y doesnt have same parent
                if (cur.left != null && cur.right != null) { 
                    if (cur.left.val == A && cur.right.val == B) { 
                        return false;
                    }
                    if (cur.left.val == B && cur.right.val == A) { 
                        return false;
                    }
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            // if both exist at same level we return true
            if (isAexist && isBexist)  return true;
        }
        return false;
    }
}
