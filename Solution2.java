// Time Complexity :O(n) touching all nodes once
// Space Complexity :O(n/2) maximum number of elements in a queue at one time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //BFS
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            //initialize found variable before each level
            boolean xFound=false;
            boolean yFound=false;
            for(int i=0;i<size;i++){
                
                TreeNode node=q.poll();
                //if both x and y are childen of same parent return false
                if(node.left!=null && node.right!=null && node.left.val==x && node.right.val==y){
                    return false;
                }
                if(node.left!=null && node.right!=null && node.right.val==x && node.left.val==y){
                    return false;
                }
                if(node.val==x){
                    xFound=true;
                }
                if(node.val==y){
                    yFound=true;
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            // after each level if s and y are found means they exist at same level
            if(xFound && yFound){
                return true;
            }
        }
        return false;
    }

//DFS

// Time Complexity :O(n) touching all nodes once
// Space Complexity :O(n/2) maximum number of elements in a recursive stack at one time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
TreeNode xparent;
TreeNode yparent;
int x_level;
int y_level;
public boolean isCousins1(TreeNode root, int x, int y) {
    if(root==null)
        return false;
    // if x or y is the root then level=0 and xparent/yparent=null 
    // these are default values so need not check;
    dfs(root,0,x,y);
    
    // cousins are at same level and dont have same parent
    return xparent!=yparent && x_level==y_level;
}
private void dfs(TreeNode root, int level, int x,int y){
    
//base
if(root==null)
    return;

    
//logic
// if x is found as the child of root, set the parent and one level more than the parent
if(root.left!=null && root.left.val==x || root.right!=null && root.right.val==x){
    xparent=root;
    x_level=level+1;
}
    
// if y is found as the child of root, set the parent and one level more than the parent    
if(root.left!=null && root.left.val==y || root.right!=null && root.right.val==y){
    yparent=root;
    y_level=level+1;
}
    dfs(root.left,level+1,x,y);
    dfs(root.right,level+1,x,y);
    
}
}
