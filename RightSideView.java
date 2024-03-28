/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/* Approach 1 - BFS
TC: O(n)
SC: O(n)
*/
class CousinsBT {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null ) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i< size; i++){
                TreeNode curr = q.poll();
                if(i == size - 1){
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

/*
Approach 2 - DFS
TC: O(n)
SC: O(h)
*/
class CousinsBT {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null ) return result;
        return (helper(root,0));
    }
    private List<Integer> helper(TreeNode root, int level){
        if (root == null) return result;
        if(result.size() == level){
            result.add(root.val);
        }
        helper(root.right, level+1);
        helper(root.left, level+1);

        return result;
    }
}