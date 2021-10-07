//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        helperMethod(root, 0);
        return result;
    }
    
    public void helperMethod(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        if(result.size() == depth) {
            result.add(root.val);
        }
        helperMethod(root.right, depth + 1);
        helperMethod(root.left, depth + 1);
    }
}