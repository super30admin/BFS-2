// Time Complexity : O(N)
// Space Complexity : O(N)
// Leetcode passes: yes
// Any problems while solving this problem : no

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
        if(root == NULL)
            return false;
        
        q.push(root);
        while(!q.empty())
        {
            int size = q.size();
            bool is_x = false;
            bool is_y = false;
            for(int i = 0; i < size; i++)
            {
                TreeNode* curr = q.front();
                q.pop();
                if(curr->val == x) is_x = true;
                if(curr->val == y) is_y = true;
                
                if(curr->left and curr->right)
                {
                    if((curr->left->val == x and curr->right->val == y) or (curr->left->val == y and curr->right->val == x)) return false;
                }
                if(curr->left) q.push(curr->left);
                if(curr->right) q.push(curr->right);
            }
            if(is_x and is_y) return true;
        }
        return false;
        
    }
};