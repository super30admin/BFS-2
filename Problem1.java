// https://leetcode.com/problems/binary-tree-right-side-view/
// Time complexity : O(N)
// Space complexity : O(1) Ignoring recursion stack

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        int depth = depth(root);
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<depth;i++)
            l.add(Integer.MIN_VALUE);
        
        helper(root,l,0);
        return l;
    }
    

    //There should be only one node visible for each level.
    public void helper(TreeNode root,List<Integer> l, int level){
        if(root == null)
            return;

        l.set(level,root.val);
        helper(root.left,l,level+1);
        helper(root.right,l,level+1);
    }
    
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}