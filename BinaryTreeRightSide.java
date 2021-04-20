/**Leetcode Question 199 - Binary Tree Right Side  */
/**Algorithm - BFS
 * Create a queue and add the root to it
 * Maintain a size variable. When i == size -1, add the element to the result
 */
/**TC- O(N)
 * SC- O(N/2 +1) = O(N)
 */
public class BinaryTreeRightSide {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i =0; i< size; i++){
                    TreeNode curr = q.poll();
                    if(i == size-1){
                        result.add(curr.val);
                    }
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
            return result;
        }
    }
}
/** Algo - DFS */
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int lvl){
        //Base
        if(root == null){
            return;
        }
        
        //Logic
        if(lvl == result.size()){
            result.add(root.val);
        }
        else{
            result.set(lvl,root.val);
        }
        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
    }
}