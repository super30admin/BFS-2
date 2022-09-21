// BFS
public class BTRightSideViewBFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // null check
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                // for left view - if(i == 0)
                if(i == size-1) result.add(curr.val);
                
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return result;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)

// DFS
public class BTRightSideViewDFS {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        // null check
        if(root==null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int depth){
        //base
        if(root==null) return;
        
        //logic
        if(depth==result.size()) result.add(root.val);
        
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}

// Time Complexity - O(n)
// Space Complexity - O(h)