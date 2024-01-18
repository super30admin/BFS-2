// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea here is recursively traverse and push the right most element to the vector.


#include<vector>

// Definition for a binary tree node.
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
    std::vector<int> result;
    std::vector<int> rightSideView(TreeNode* root) { 
        if(root == nullptr)
        {
            return result;
        }

        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode* root, int depth)
    {
        // base
        if(root == nullptr)
        {
            return;
        }
        //logic

        if(depth == result.size())
        {
            result.push_back(root->val);
        }

        dfs(root->right, depth+1);
        dfs(root->left, depth+1);
    }
};