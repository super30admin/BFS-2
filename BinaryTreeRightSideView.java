// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Preorder DFS.
Perform DFS. At each point increment the level
if result size is same as level then add to result
else if level < result size then replace the value at level with curr val
*/
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //O(n) time, O(h) space vs O(n) space in BFS
        if(root==null) return new ArrayList<>();

        List<Integer> result= new ArrayList<>();

        helper(root, result,0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result, int level){
        if(root==null) return;

        if(level<result.size()){
            result.set(level,root.val);
        }else if(level==result.size()){
            result.add(root.val);
        }

        helper(root.left, result, level+1);
        helper(root.right,result,level+1);
    }
}
