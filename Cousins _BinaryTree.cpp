//Time Complexity:O(n)
//Space complexity : O(h)
#include<iostream>
#include<vector>

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
    int x_l, y_l;
    TreeNode* x_p;
    TreeNode* y_p;
    bool isCousins(TreeNode* root, int x, int y) {
        x_l = y_l = -1;
        x_p = y_p = nullptr;
        helper(root, x, y, 0, nullptr);
        return x_l == y_l && x_p != y_p;
        
    }
    void helper(TreeNode* root, int x, int y, int l, TreeNode* p) {
        if (root == nullptr) return;

        if (root->val == x) {
            x_l = l;
            x_p = p;
        }

        if (root->val == y) {
            y_l = l;
            y_p = p;
        }

        helper(root->left, x, y, l + 1, root);
        helper(root->right, x, y, l + 1, root);
    }
};