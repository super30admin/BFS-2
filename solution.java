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
class Solution {
    int max_level=0;
    List<Integer> li=new ArrayList<Integer>();
    
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,1);
        return li;
    }
    public void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(level>max_level){
            li.add(root.val);
                max_level=level;
        }
        dfs(root.right,level+1);
        dfs(root.left,level+1);
        
        
    }
}






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
class Solution {
    HashMap<Integer,Integer> parents=new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> levels=new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        parents.put(root.val,root.val);
        levels.put(root.val,0);
        dfs(root,0);
        if(parents.get(x)==parents.get(y)){
            return false;
        }
        if(levels.get(x)!=levels.get(y)){
            return false;
        }
        return true;
        
        
    }
    private void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parents.put(root.left.val,root.val);
            levels.put(root.left.val,level+1);
            dfs(root.left,level+1);
        }
        if(root.right!=null){
            parents.put(root.right.val,root.val);
            levels.put(root.right.val,level+1);
            dfs(root.right,level+1);
        }
        
    }
}