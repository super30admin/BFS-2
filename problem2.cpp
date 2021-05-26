/*
Time complexity - O(N)
Space complexity - O(N)
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
    bool isCousins(TreeNode* root, int x, int y) {
        if (!root) return true;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int cnt = q.size();
            bool x_fnd = false, y_fnd = false;
            while (cnt-- > 0){
                TreeNode* node = q.front();
                q.pop();
                if (node->val == x) x_fnd = true;
                if (node->val == y) y_fnd = true;
                if (node->left && node->right){
                    if (node->left->val == x && node->right->val == y || 
                        node->left->val == y && node->right->val == x) return false;
                }
                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }
            if (x_fnd && y_fnd) return true;
            if (x_fnd || y_fnd) return false;
        }
        return false;
    }
};