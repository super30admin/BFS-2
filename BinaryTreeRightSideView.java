// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Iterative approach
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            int s = queue.size();
            for(int i=0; i<s; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
                if(i == s-1)
                    res.add(temp.val);
            }
        }

        return res;
    }
}


// Recursive
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        res = new ArrayList<>();
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int currDepth) {

        if(root == null)
            return;

        if(res.size() == currDepth)
            res.add(root.val);

        helper(root.right, currDepth+1);
        helper(root.left, currDepth+1);

    }
}