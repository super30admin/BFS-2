//Time Complexity: O(n)
//Space Complexity: O(h), h is the height of the tree for dfs for bfs O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

class Solution {
    private List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int level){
        //null
        if(root == null) return;
        //logic
        if(result.size() == level){
            result.add(root.val);
        }
        
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}

/*dfs from left first
class Solution {
    private List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int level){
        //null
        if(root == null) return;
        //logic
        if(result.size() == level){
            result.add(root.val);
        }else{//do not use this if you want the left side view
            result.set(level,root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
*/

/*bfs
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(i == size-1) result.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }
}
*/