// Time Complexity: O(n)
// Space Complexity: size of recursive stack

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
    TreeNode* parent; 
    bool isCousins(TreeNode* root, int x, int y) {
        parent = nullptr; 
        int level_x = dfs(root, x, 0); 
        TreeNode* parent_x = parent; 
        parent = nullptr; 
        int level_y = dfs(root, y, 0); 
        TreeNode* parent_y = parent; 

        if(level_x == level_y && parent_x != parent_y) return true; 
        return false; 
    }

    int dfs(TreeNode* node, int value, int h) {
        if(node == nullptr) return -1; 
        if(node->val == value) return h;

        parent = node; 
        int l = dfs(node->left, value, h+1); 
        if(l > 0) {
            return l;
        } 

        parent = node;
        int r = dfs(node->right, value, h+1);
        return r; 

    }
};