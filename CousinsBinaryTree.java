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
    int ans=-1;
    public boolean isCousins(TreeNode root, int x, int y) {
        findParent(root,x,-1);
        int t = ans;
        // System.out.println("t : "+t);
        findParent(root,t,-1);
        int t1=ans;
        // System.out.println("t1 : "+t1);
        
        findParent(root,y,-1);
        int s = ans;
        // System.out.println("s : "+s);
        findParent(root,s,-1);
        int s1=ans;
        // System.out.println("s1 : "+s1);
        
        if(t1==s1 && t1!=-1 && s1!=-1 && t!=s){
            return true;
        }
        
        while(t1!=-1 && s1!=-1){
            findParent(root,t1,-1);
            t1=ans;
                    System.out.println("t1 : "+t1);
            findParent(root,s1,-1);
            s1=ans;
            System.out.println("s1 : "+s1);
            if(t1==s1 && t1!=-1 && s1!=-1 && t!=s){
            return true;
        }
        }
        
        return false;
        }
    void findParent(TreeNode node, int val, int parent) 
    { 
    if (node == null) 
        return; 
  
    // If current node is the required node 
    if (node.val == val)  
    { 
  
        ans = parent;
    } 
    else 
    { 
  
        findParent(node.left, val, node.val); 
        findParent(node.right, val, node.val); 
    }
    } 
}

//Time complexity - O(n) n is the number of nodes
//Space complexity - O(h) h is the height of recursion stack
