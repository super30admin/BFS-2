//Time O(n)
//Space O(n)
//Leetcode: yes
//Issue seen: none
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if (!root)
            return false;

        queue<TreeNode*> q;
        q.push(root);
        int x_parent = 0;
        int y_parent = 0;
        int x_level = 0;
        int y_level = 0;
        int level = 0;
        while (!q.empty()) {
            int n = q.size();
            level++;
            for (int i = 1; i <= n; i++) {
                TreeNode* node = q.front();
                q.pop();

                if (node->left) {
                    q.push(node->left);
                    if (node->left->val == x) {
                        x_parent = node->val;
                        x_level = level;
                    } else if (node->left->val == y) {
                        y_parent = node->val;
                        y_level = level;
                    }
                }
                if (node->right) {
                    q.push(node->right);
                    if (node->right->val == x) {
                        x_parent = node->val;
                        x_level = level;
                    } else if (node->right->val == y) {
                        y_parent = node->val;
                        y_level = level;
                    }
                }
            }
            if((x_parent && y_parent) && ((x_parent != y_parent) && (x_level == y_level)))
               return true;
        }
        
        return false;
    }
};
