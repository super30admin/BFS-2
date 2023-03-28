// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
Traverse the root and the right side of it. At each level, check if element exists, if it doesn't add the element and move to the next side. 
Once the right side is done, traverse left and check if an extra level exists. 
If so, add the element into it. 
 * 
 */


class Problem1 {
   List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level){
        if (root == null )
            return ; 
        if(level == result.size())
            result.add(root.val);
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}