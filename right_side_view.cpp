// TC: O(N) where N is the total no of nodes in the tree;
// SC: O(N/2)


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
    vector<int> rightSideView(TreeNode* root) {
        queue<TreeNode*>q;
        vector<int>result;
        if(root==NULL)return result;
        q.push(root);
        while(!q.empty()){
            int sz = q.size();
            for(int i = 0; i < sz;i++){
            root = q.front();q.pop();
            if(i == sz-1)result.push_back(root->val);
            if(root->left)q.push(root->left);
            if(root->right)q.push(root->right);
            }
        }
        return result;              
    }
};


