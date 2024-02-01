/*
 ? Problem: Binary Tree Right Side View
 * Time Complexity : O(n)
 * Space Complexity : O(h) -> h = height of the tree
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>
#include <queue>

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
    std::vector<int> rightSideView(TreeNode* root) {

        if (root == nullptr) return {};

        std::vector<int> result;
        std::queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode* node = q.front();
                q.pop();
                if (i == 0) result.push_back(node->val);

                if (node->right != nullptr) q.push(node->right);
                if (node->left != nullptr) q.push(node->left);
            }
        }
        return result;
    }
};