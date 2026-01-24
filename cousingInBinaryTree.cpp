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
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> q;
        if (root == nullptr) {
            return false;
        }

        bool xNode = false, yNode = false;

        auto hasSameParent = [&](TreeNode *node, int x, int y) -> bool {
            if (node->left && (node->left->val == x || node->left->val == y)) {
                if (node->right && (node->right->val == x || node->right->val == y)) {
                    return true;
                }
            }
            return false;
        };

        q.push(root);

        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                TreeNode* node = q.front();
                q.pop();

                if (hasSameParent(node, x, y)) {
                    return false;
                }

                if (node->val == x ) {
                    xNode = true;
                }

                if (node->val == y) {
                    yNode = true;
                }

                if (xNode == true && yNode == true) {
                    return true;
                }

                if (node->left != nullptr) {
                    q.push(node->left);
                }

                if (node->right != nullptr) {
                    q.push(node->right);
                }
            }
            if (xNode || yNode) {
                return false;
            }
        }
        return false;
    }
};
