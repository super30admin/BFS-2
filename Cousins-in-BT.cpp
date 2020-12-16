// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

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
    int x_lvl, y_lvl;
    TreeNode *x_parent, *y_parent;
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL){
            return true;
        }
        dfs(root, NULL, 0 , x, y);
        return x_lvl==y_lvl && x_parent!=y_parent; 
    }
    
    void dfs(TreeNode* root, TreeNode* parent, int lvl, int x, int y){
        if(root == NULL){
            return;
        }
        if(root->val == x){
            x_lvl = lvl;
            x_parent=parent;
        }
        if(root->val == y){
            y_lvl = lvl;
            y_parent=parent;
        }
        dfs(root->left, root, lvl+1,x,y);
        dfs(root->right, root, lvl+1,x,y);
    }
};
