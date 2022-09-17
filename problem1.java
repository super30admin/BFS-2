// Problem1 - https://leetcode.com/problems/binary-tree-right-side-view/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class BFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();

        int depth = 0;
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i == size - 1){
                    res.add(curr.val);
                }
                if(curr.right!=null) q.add(curr.right);
                if(curr.left!=null) q.add(curr.left);
              
            }
        }
        return res;
    }
}

// DFS Method
// Time Complexity : O(n)
// Space Complexity : O(h).... O(n) worst case
class DFS {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root == null) return result;
            dfs(root,0,result);
            return result;
        }
    
        private void dfs(TreeNode root, int depth, List<Integer> result){
             //base
            if(root == null) return;
            
            if(depth == result.size()){
                result.add(root.val);
            }
            //logic
                
            dfs(root.right, depth+1, result);
            dfs(root.left, depth+1, result);
        }
}