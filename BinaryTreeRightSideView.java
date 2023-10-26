// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root == null)
//             return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 TreeNode popped = q.poll();
//                 if(i == size - 1){
//                     result.add(popped.val);
//                 }
//                 if(popped.left != null)
//                     q.add(popped.left);
//                 if(popped.right != null)
//                     q.add(popped.right);
//             }
//         }
//         return result;
//     }
// }

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root == null)
            return;

        if(result.size() == level){
            result.add(root.val);
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
