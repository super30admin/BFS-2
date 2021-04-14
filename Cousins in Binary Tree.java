//BFS
//Time Complexity : O(n)
//Space Complexity : O(n). O(n/2) because not all nodes are added into the queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        //add the root to queue
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            //use variable to keep track of x and y 
            boolean x_found = false, y_found = false;
            //within a level if x and y nodes are present
            for(int i=0;i<size;i++){
                //pop the current node from queue
                TreeNode curr = q.poll();
                //check if this value is equal to x
                if(curr.val == x){
                    //if so then mark that x is found
                    x_found = true;
                }
                //check if this value is equal to y
                if(curr.val == y){
                    //if so then mark that y is found
                    y_found = true;
                }
                //if this node has left and right child nodes
                if(curr.left!=null && curr.right!=null){
                    //check if the child nodes are equal to x and y
                    if((curr.left.val==x && curr.right.val == y) ||(curr.left.val==y && curr.right.val == x)){
                        //this indicates that the child nodes are from same parents and hence not cousins
                        return false;
                    }
                }
                //perform the regular bfs: add the left and right child nodes to queue
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            //after passing a level check if x and y are located
            if(x_found && y_found){
                //this indicates that x and y are found from same level and different parents hence cousins
                return true;
            }
            //only if any one of x or y is found, then the x and y are not of same level
            if(x_found || y_found){
                return false;
            }
        }
        //x and y were not found
        return false;
    }
}
//DFS
//Time Complexity : O(n)
//Space Complexity: O(h).h is height of the tree. Ifrecurssive stack is taken into consideration then the space complexity is O(n)
class Solution {
    //gloval variable to update the parents and levels
    TreeNode x_parent,y_parent;
    int x_level=0,y_level=0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        //helper function to perform dfs traversal
        dfs(root, null, 0, x, y);
        //if the parents of x and y are not same and if levels are same then cousins else not
        return (x_parent!=y_parent && x_level==y_level);
    }
    private void dfs(TreeNode root,TreeNode parent,int level,int x, int y){
        //when the node is null or hwn both x and y parents are not null we can stop thus preventing extra recursive calls
        if(root == null||x_parent!=null && y_parent!=null){
            return;
        }
        //check if the current node value is equal to x or y if so store its parent and level
        if(root.val == x){
            x_parent = parent;
            x_level = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_level = level;
        }
        //continue processing with left and right child nodes
        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);

    }
}