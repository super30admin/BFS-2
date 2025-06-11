//Time Complexity:
//Space Compexity:

//Using BFS

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
            for(int i=0; i<size; i++){
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

//left side view using bfs

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(i == 0){
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

//Time Complexity: O(n)
//Space Complexity: Auxillary space: None, Worst case: O(h)
//Using DFS - Right subtree recursion call first

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, 0, result);
        return result;
        
    }

    private void dfs(TreeNode root, int level, List<Integer> result){
        //base
        if(root == null)
            return;
        //logic
        if(result.size() == level){ // this logic is based on preorder. This will not work for inorder or postorder traversal
            result.add(root.val);
        }
        level++;
        dfs(root.right, level, result);
        dfs(root.left, level, result);
    }
}

//Using DFS - Left recursion calls first

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, 0, result);
        return result;
        
    }

    private void dfs(TreeNode root, int level, List<Integer> result){
        //base
        if(root == null)
            return;
        //logic
         if(result.size() == level){
            result.add(root.val);
        }else{
            result.set(level, root.val);
        }
        
        dfs(root.left, level+1, result);
       
        dfs(root.right, level+1, result);
    }
}