// TIME: O(N)
// SPACE: O(height)
// SUCCESS on LeetCode

public class RightSideViewBT {
    List<Integer> answer;
    public List<Integer> rightSideView(TreeNode root) {
        // DFS using left call first
        answer = new ArrayList<>();
        helper(root, 0);
        return answer;
    }
    
    private void helper(TreeNode root, int level) {
        if (root == null) return;
        if (level == answer.size()) {
            answer.add(root.val);
        } else {
            answer.set(level, root.val);
        }
        helper(root.left, level+1);
        helper(root.right, level+1);
    } 
}
