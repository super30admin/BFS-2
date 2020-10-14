// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No

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
        queue<pair<TreeNode*,TreeNode*>> q;
        q.push({root,NULL});
        TreeNode *parA=NULL,*parB=NULL;
        while (!q.empty()) {
            int size=q.size();
            while (size--) {
                auto temp=q.front();
                TreeNode *node=temp.first;
                TreeNode *parent=temp.second;
                q.pop();
                int value =node->val;
                if (value == x) {
                   parA=parent; 
                }
                
                if (value == y) {
                    parB=parent;
                }
                
                if (node->left!=NULL)
                    q.push({node->left,node});
                
                if (node->right!=NULL)
                    q.push({node->right,node});
                
                if (parA!=NULL && parB!=NULL)
                    break;
            }    
            if ((parA!=NULL && parB==NULL) || (parA==NULL && parB!=NULL))
                return false;
            
            if (parA!=NULL && parB!=NULL)
                return parA!=parB;
        }
        return false;
    }
};