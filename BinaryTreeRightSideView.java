// USING BFS
// TC: O(N)
// SC:  O(H) HEIGHT OF TREE
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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            int last = 0;
            
            for(int i=0; i< size; i++){
                TreeNode curr = q.poll();
                last = curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
               
            }
             result.add(last);
            
        }
        
        return result;
        
    }
}

// traverse left side first



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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int lvl){
        if(root == null)
            return;
        if(result.size() == lvl){
            result.add(root.val);
        }else{
            result.set(lvl, root.val);
        }
        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
        
        
    }
}







// traverse right side first


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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int lvl){
        if(root == null)
            return;
        if(result.size() == lvl){
            result.add(root.val);
        }
        dfs(root.right, lvl+1);
        dfs(root.left, lvl+1);
        
    }
}