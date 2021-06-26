//using BFS checking if x and y exist in the subtrees
//if exist setting their respective px and py
// checking if parents are different and returning true
//Time: O(n)
//Space: O(n)

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
        q.push(root);
        TreeNode* px=nullptr;
        TreeNode* py=nullptr;
        bool flag=false;
        while(!q.empty())
        {
            int len;
            for(int i=0;i<len;i++)
            {
                TreeNode* n=q.front();
                q.pop();
                if(n->left!=nullptr)
                {
                    if(n->left->val==x)
                        px=n;
                    if(n->left->val==y)
                        py=n;
                }
                if(n->right!=nullptr)
                {
                      if(n->right->val==x)
                        px=n;
                    if(n->right->val==y)
                        py=n;
                }
            }
           if(px!=nullptr and py!=nullptr and px->val!=py->val)
            {
                return true;
            }
            
        }
        return false; 
    }
};
