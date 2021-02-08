// Time Complexity : O(n) or O(V)
// Space Complexity : O(1) o(n) for the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning  



/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
     int depthX = -1;
     int depthY = -1;
        
        TreeNode* parentX = NULL;
        TreeNode* parentY = NULL;
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL) return false;
        
        helper(root,x,y,0, NULL);
        
        if((depthX == depthY) && (parentX!= parentY)){
            return true;
        }
        
        
       return false;
    }
    
    void helper(TreeNode* root, int x, int y, int depth, TreeNode* parent){
        if(root == NULL) return;
        
        if(root->val ==x){
            depthX = depth;
            parentX = parent;
        }
         
        if(root->val ==y){
            depthY = depth;
            parentY = parent;
        }
        helper(root->left, x, y, depth+1, root);
         helper(root->right, x, y, depth+1, root);
        
    }
};