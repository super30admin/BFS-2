// Approach 1: Using DFS
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using DFS, we traverse the tree and keep track of parent node and depth
// Once we have found x and y nodes, we then check whether their height is the same and their parents are different

class Solution {
    int depthX, depthY;
    TreeNode parentX, parentY;
    public boolean isCousins(TreeNode root, int x, int y) {
        parentX = null; 
        parentY = null;
        depthX = -1; 
        depthY = -1;
        helper(root, null, 0, x, y);
        return (depthX==depthY) && (parentX!=parentY);
    }
    private void helper(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root==null)
            return;
        if(root.val==y){
            parentY = parent;
            depthY = depth;
        }
        if(root.val==x){
            parentX = parent;
            depthX = depth;
        }
        if(depthX == -1 || depthY == -1) helper(root.left, root, depth+1, x,y);
        if(depthX == -1 || depthY == -1) helper(root.right, root, depth+1,x,y);

    }
}

// Approach 2: Using BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can traverse the tree in a BFS manner. We keep track of the level, and keep a 1:1 mapping of the parent in a separate queue
// We need to find both elements at same level, else we return false
// If they are at the same level, we see to that the parents are not equal

class Solution {
    boolean foundX, foundY;
    TreeNode parentX, parentY;
    public boolean isCousins(TreeNode root, int x, int y) {
        return helper(root, x, y);
    }
    private boolean helper(TreeNode root, int x, int y){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> parentQ = new LinkedList<TreeNode>();
        q.add(root);
        parentQ.add(null);
        while(!q.isEmpty()){
            parentX = null; 
            parentY = null;
            foundX = false; 
            foundY = false;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                TreeNode currParent = parentQ.poll();
                if(curr.val==x){
                    foundX = true;
                    parentX = currParent;
                }
                if(curr.val==y) {
                    foundY = true;
                    parentY = currParent;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                    parentQ.add(curr);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    parentQ.add(curr);
                }
            }
            if(foundX && foundY )
                return (parentX != parentY);
            if(foundX || foundY) return false;
        }
        return false;
    }
}

// Approach 3: Using BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can traverse the tree in a BFS manner
// Similar to approach 2, but while inserting a node's children, we do a check to see if x & y have the same parent
// We need to find both elements at same level, else we return false

class Solution {
    boolean foundX, foundY;
    public boolean isCousins(TreeNode root, int x, int y) {
        return helper(root, x, y);
    }
    private boolean helper(TreeNode root, int x, int y){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        foundX = false; 
        foundY = false;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && curr.right!=null)
                {
                    if((curr.left.val==x && curr.right.val ==y) ||
                        (curr.right.val==x && curr.left.val ==y))
                        return false;
                }
                if(curr.val==x)
                    foundX = true;
                if(curr.val==y)
                    foundY = true;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(foundX && foundY)
                return true;
            if(foundX || foundY) return false;
        }
        return false;
    }
}