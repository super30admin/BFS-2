// Time Complexity : O(N) where N represents the no.of nodes in the tree
// Space Complexity : O(1) as we are only using 4 temporary variables
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/cousins-in-binary-tree/
// Submission Link: https://leetcode.com/submissions/detail/542461187/

class Solution {
    int x_depth, y_depth;
    int x_parent, y_parent;
public:
    bool isCousins(TreeNode* root, int x, int y) {
        x_parent = -1;
        y_parent = -1;
        
        helper(root, NULL, x, y, 0);
        
        if(x_depth != y_depth)
            return false;
        
        if(x_parent == y_parent)
            return false;
        
        return true;
    }
    
    void helper(TreeNode* root, TreeNode* parent, int x, int y, int depth){
        if(root == NULL)
            return;
        
        if(root -> val == x){
            x_depth = depth;
            if(parent != NULL)
                x_parent = parent -> val;
        }
        
        if(root -> val == y){
            y_depth = depth;
            if(parent != NULL)
                y_parent = parent -> val;
        }
        
        helper(root -> left, root, x, y, depth + 1);
        helper(root -> right, root, x, y, depth + 1);
    }
};