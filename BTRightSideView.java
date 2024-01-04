// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : Recursion and BFS

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        return helper(root, new ArrayList(), 0);
    }

    private List<Integer> helper(TreeNode root, List<Integer> result, int level)
    {
        if(root == null) return result;

        else if(level == result.size()) result.add(root.val);

        helper(root.right, result, level + 1);
        helper(root.left, result, level + 1);

        return result;
    }
}