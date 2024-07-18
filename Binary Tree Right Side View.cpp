// time: O(n)
// space: O(n)

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
        vector<int> result;
        if(root == NULL) {
            return result;
        }
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            
            int sz = q.size();    
            for(int i = 0; i < sz; i++) {
                
                TreeNode* curr = q.front();
                
                q.pop();
                if(curr->left != NULL) {
                    q.push(curr->left);
                }
                if(curr->right != NULL) {
                    q.push(curr->right);
                }
                if(i == sz-1) {
                    result.push_back(curr->val);
                }
            }
            
            
        }
        return result;
    }
};