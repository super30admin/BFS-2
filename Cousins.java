// Time Complexity: O(n)
// Space Complexity: O(h) h=ht of stack

// Approach: Check if the 2 nodes have different parent and same depth by DFS, if they are, then they're cousins,
// Otherwise, they're not.

class Solution {
    TreeNode x_parent, y_parent;
    int x_depth, y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        dfs(root,null,0,x,y);
        return x_depth==y_depth && x_parent!=y_parent;
    }
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if(root==null) return;
        if(root.val == x) {
            x_parent = parent; x_depth = depth;
        }
        if(root.val == y) {
            y_parent = parent;
            y_depth = depth;
        }
        dfs(root.left,root,depth+1,x,y);
        dfs(root.right,root,depth+1,x,y);
    }
}


// Time Complexity - O(n)
// Space Complexity - O(n) n= size of queue. Queue contains max number of elements when we are traversing at the last level or leaf nodes

// Approach: We do level order traversal(BFS) and add current node to the queue and check if its value is equal to x or y, 
// then we know that we found the x or y node in the tree.
// Then we check if its children has x and y value, if yes, then we return false as they are siblings and not cousins
// Then we add the left and right child of current node to the queue and repeat the same procedure again until queue is empty
// If x and y are found in the tree then we return true, otherwise we return false.

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int count = q.size();
            boolean x_found=false;
            boolean y_found=false;
            for(int i=0;i<count;i++) {
                TreeNode curr=q.poll();
                if(curr.val==x) x_found=true;
                if(curr.val==y) y_found=true;
                if(curr.left!=null && curr.right!=null) {
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(x_found && y_found) return true;
        }
        return false;
    }
}