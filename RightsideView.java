//  TC: SC: O(n)  
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result, 0);
        return result;
    }
    private void helper(TreeNode root, List<Integer> result, int level){
        //base case
        if(root == null) return;

        //logic
        if(result.size() == level){
            result.add(root.val);
        }
        

        helper(root.right, result, level+1);
        helper(root.left, result, level+1);
    }
}