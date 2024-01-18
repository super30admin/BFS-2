// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Check parent for x, y. If parents are different and they are of same depth, then we return true.

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
class Solution {
public:
    int depth_x = 0;
    int depth_y = 0;
    int x_elm;
    int y_elm;
    TreeNode* parent_x;
    TreeNode* parent_y;
    bool isCousins(TreeNode* root, int x, int y) {
        x_elm = x;
        y_elm = y;
        dfs(root, nullptr, 0);
        return ((depth_x == depth_y) && (parent_x != parent_y));
    }
    void dfs(TreeNode* root, TreeNode* parent, int depth)
    {
        if(root == nullptr)
        {
            return;
        }

        // logic
        if(root->val == x_elm)
        {
            depth_x = depth;
            parent_x = parent;
        }

        if(root->val == y_elm)
        {
            depth_y = depth;
            parent_y = parent;
        }

        dfs(root->left, root, depth+1);
        dfs(root->right, root, depth+1);

    }
};