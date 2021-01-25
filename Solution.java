
 // Definition for a binary tree node.
/* public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 */
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.val);
        }
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}
///////////
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll(); 
                if(i == size-1){
                    result.add(curr.val);
                }
                if(curr.left!=null)que.add(curr.left);
                if(curr.right!=null)que.add(curr.right);
            }
        }return result;
    }
}