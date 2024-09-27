//Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
public:
    TreeNode* x_parent, *y_parent;
    int x_level; int y_level;
    void helper(TreeNode* root, TreeNode* parent, int x, int y, int level ){
        if(root==NULL) return;
        
        if(root->val==x){
            x_parent = parent;
            x_level=level;
        }
        
        if(root->val==y){
            y_parent = parent;
            y_level = level;
        }
        
        helper(root->left, root,x, y, level+1);
        helper(root->right,root, x, y,  level+1);
        
    }
    
    bool isCousins(TreeNode* root, int x, int y) {
        // DFS solution
        if(root==NULL) return false;
        
        helper(root, NULL, x, y, 0);
        
        if(x_parent!=y_parent && x_level==y_level) return true;
        
        return false;
    }
};