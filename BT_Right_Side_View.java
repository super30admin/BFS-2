//Time Complexity - O(n)
//Space complexity - O(1)
class Solution {
    private List<Integer> answer = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,1);
        return answer;
    }

    private void helper(TreeNode root,int level){
        if(root == null) return;
        if(level > answer.size()) answer.add(root.val);

        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}
