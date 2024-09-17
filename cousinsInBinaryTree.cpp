//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using bfs
//any issues faced? yes, but understood it

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
        if(root==NULL)
            return true;
        queue<TreeNode*>q;
        if(root)
            q.push(root);
        while(!q.empty())
        {
            int size=q.size();
            bool isx=false;
            bool isy=false;
            for(int i=0; i<size; i++)
            {
                TreeNode* curr=q.front();
                q.pop();
                if(curr->val==x)
                    isx=true;
                if(curr->val==y)
                    isy=true;
                if(curr->left!=NULL && curr->right!=NULL)
                {
                    if((curr->left->val==x && curr->right->val==y) || (curr->left->val==y && curr->right->val==x))
                    {
                        return false;
                    }
                }
                if(curr->left!=NULL)
                    q.push(curr->left);
                if(curr->right!=NULL)
                    q.push(curr->right);
            }
            if(isx && isy)
                return true;
        }
        return false;
    }
};