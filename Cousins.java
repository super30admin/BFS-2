// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//in this approach we maintain a queue if the children of current node are equal to x and y then we make the pointers true. if both the values are equal to x and y we return false
//then we add the children in the queue. If both the booleans are true we return true otherwise false;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList();
        // TreeNode parentX = null;
        // TreeNode parentY = null;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i=0;i<size;i++){
                TreeNode curr =  q.poll();
                if(curr.val == x ){
                    xFound = true;
                } 
                if(curr.val == y){
                    yFound = true;
                } 
                if(curr.left!= null && curr.right!=null){
                    if(curr.left.val == x && curr.right.val == y)return false;
                    if(curr.left.val == y && curr.right.val == x)return false;
                }
                if(!xFound && !yFound && curr.left!=null){
                    q.add(curr.left);
                }
                if(!xFound && !yFound && curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(xFound && yFound)return true;
            if(xFound || yFound)return false;
        }
        return false;

        
    }
}


//bfs with parent queue as well
public class Cousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList();
        Queue<TreeNode> pq = new LinkedList();
        TreeNode parentX = null;
        TreeNode parentY = null;
        q.add(root);
        pq.add(null);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i=0;i<size;i++){
                TreeNode curr =  q.poll();
                TreeNode pCurr = pq.poll();
                if(curr.val == x ){
                    xFound = true;
                    parentX = pCurr;
                } 
                if(curr.val == y){
                    yFound = true;
                    parentY= pCurr;
                } 
                if(curr.left!=null){
                    q.add(curr.left);
                    pq.add(curr);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            if(xFound && yFound)return parentX!=parentY;
            if(xFound || yFound)return false;
        }
        return false;

        
    }
}


//dfs
class Solution {
    TreeNode parentX;
    TreeNode parentY;
    int depthX;
    int depthY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)return false;
        dfs(root,x,y, 0,null);
        return parentX != parentY && depthX == depthY;
    }
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null)return;
        if(root.val == x){
            parentX = parent;
            depthX = depth;
        }
        if(root.val == y){
            parentY = parent;
            depthY = depth;
        }
        if(parentX == null || parentY == null)
            dfs(root.left,x,y,depth+1,root);
        if(parentX == null || parentY == null)
            dfs(root.right,x,y,depth+1,root);
    }
}