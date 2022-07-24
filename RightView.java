// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<Integer>();
        helper(root,0);
        return res;
    }
    void helper(TreeNode root,int level){
        if(root == null){
            return;
        }
        if(level == res.size()){
            res.add(root.val);
        }
        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}