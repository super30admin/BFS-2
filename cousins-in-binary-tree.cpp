// Time Complexity : O(n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <queue>

using namespace std;

// Definition for a binary tree node
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if (root == nullptr)
            return false;

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            int count = q.size();
            bool xIsFound = false;
            bool yIsFound = false;

            for (int i = 0; i < count; i++) {
                TreeNode* node = q.front();
                q.pop();

                if (node->val == x)
                    xIsFound = true;
                if (node->val == y)
                    yIsFound = true;

                if (node->left && node->right) {
                    if (node->left->val == x && node->right->val == y)
                        return false;
                    if (node->left->val == y && node->right->val == x)
                        return false;
                }

                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
            }

            if (xIsFound && yIsFound)
                return true;
        }

        return false;
    }
};
