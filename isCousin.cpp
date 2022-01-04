// Time Complexity :  O(n) 
// Space Complexity : O(h) -> where h : height of tree
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english

/* DFS appoach :- 
 *      Find parent node and level of both x and y. If both node parents are different and levels are same then return true else return false.
 */

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
    TreeNode *x_parent, *y_parent;
    int x_level, y_level;
    bool isCousins(TreeNode* root, int x, int y) {
        if (root == nullptr)
            return false;
        
        x_parent = y_parent = nullptr;
        x_level = y_level = -1;
        
        helper(root, nullptr, x, y, 0);
        
        return (x_parent != y_parent) && (x_level == y_level);
    }
    
    void helper(TreeNode* node, TreeNode* parent, int x, int y, int level)
    {
        if (node == nullptr)
            return;
        
        if (node->val == x)
        {
            x_level = level;
            x_parent = parent;
        }
        
        if (node->val == y)
        {
            y_level = level;
            y_parent = parent;
        }
        
        if (x_parent != nullptr && y_parent != nullptr)
            return;
        
        helper(node->left, node, x, y, level + 1);
        helper(node->right, node, x, y, level + 1); 
    }
};