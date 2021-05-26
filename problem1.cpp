/*
Time complexity - O(N)
Space complexity - O(H)
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
    vector<int> res;
    vector<int> rightSideView(TreeNode* root) {
        if (!root) return {};
        helper(root, 0);
        return res;
    }
    
private:
    void helper(TreeNode* root, int lvl){
        //base
        if (!root) return;
        //logic
        if (res.size() == lvl) res.push_back(root->val);
        helper(root->right, lvl + 1);
        helper(root->left, lvl + 1);
    }
};