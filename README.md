# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

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
        List<Integer> ll =new ArrayList<>();
        // if(root!=null)
        //     return bfs(root);
        // return ll;
    
    // public static List<Integer> bfs(TreeNode root){
    //     Queue<TreeNode> qq=new LinkedList<>();
    //     List<Integer> ll=new ArrayList<>();
    //     qq.add(root);
    //     while(!qq.isEmpty()){
    //         int size=qq.size();
    //         for(int i=0;i<size;i++){
    //             TreeNode temp=qq.poll();
    //             if(temp!=null){
    //                 if(i==size-1)
    //                     ll.add(temp.val);
    //             if(temp.left!=null)
    //                 qq.add(temp.left);
    //             if(temp.right!=null)
    //                 qq.add(temp.right);   
    //             }
    //         }
    //     }
    //     return ll;
    // }
    
    
    
    //DFS
    
    deep(ll,root,0);
    return ll;
    }
    public void deep(List<Integer> ll, TreeNode root, int level){
        if(root==null)
            return;
        if(ll.size()==level)
            ll.add(root.val);
        else{
            ll.set(level,root.val);
        }
        deep(ll,root.left,level+1);
        deep(ll,root.right,level+1);
        }
}


## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

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
    int dx=0;
    int dy=0;
    TreeNode Px;
    TreeNode Py;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,x,y,0);
        return Px!=Py && dx==dy;
    }
    public void dfs(TreeNode root,TreeNode parent, int x, int y, int l){
        if(root==null)
            return;
        if(root.val==x)
        {
            Px=parent;
            dx=l;
        }
        if(root.val==y){
            Py=parent;
            dy=l;
        }
        dfs(root.left,root,x,y,l+1);
        dfs(root.right,root,x,y,l+1);
    }
}


