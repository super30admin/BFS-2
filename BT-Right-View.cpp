// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

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
    vector<int> result;
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root==NULL){
            return result;
        }
        dfs(root,0);
        return result;
    }
    void dfs(TreeNode* root, int lvl){
        if(root==NULL){
            return;
        }
        if(result.size()==lvl){
            result.push_back(root->val);
        }
        dfs(root->right, lvl+1);
        dfs(root->left, lvl+1);
    }
};
