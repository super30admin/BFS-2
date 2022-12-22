//TC : o(n)
//Sc: o(n)
//https://leetcode.com/problems/binary-tree-right-side-view/
//BFS solution
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();
                if(i==size-1){
                    result.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }
}

//dfs on right

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root, int level, List<Integer> result){
        //base
        if(root == null) return;
        
        //logic
        if(result.size() == level){
            result.add(root.val);
        }
        dfs(root.right, level+1, result);
        dfs(root.left, level+1, result);
    }
}

//dfs on left

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root, int level, List<Integer> result){
        //base
        if(root == null) return;
        
        //logic
        if(result.size() == level){
            result.add(root.val);
        }else{
            result.set(level,root.val); // replace the values if found on right side
        }
        
        dfs(root.left, level+1, result);
        dfs(root.right, level+1, result);
    }
}
