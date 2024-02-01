/*
 ? Problem: Cousins in binary tree
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

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
    bool isCousins(TreeNode* root, int x, int y) {
        std::queue<TreeNode*> q;
        q.push(root);
        int level, x_flag, y_flag;

        while (!q.empty()) {
            x_flag = false;
            y_flag = false;
            level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode* node = q.front();
                q.pop();
                if (node->left && node->right) {
                    if ((node->left->val == x && node->right->val == y) ||
                        (node->left->val == y && node->right->val == x))
                            return false;
                }

                if (node->left) {
                    q.push(node->left);
                    if (node->left->val == x) x_flag = true;
                    if (node->left->val == y) y_flag = true;
                }
                if (node->right != nullptr) {
                    q.push(node->right);
                    if (node->right->val == x) x_flag = true;
                    if (node->right->val == y) y_flag = true;
                }

                if (x_flag && y_flag) return true;
            }

            if (x_flag || y_flag) return false;
        }

        return false;
    }
};