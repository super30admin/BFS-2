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
 Time Complexity = O(N)
 Space Complexity = O(h)
 */
class Solution {
public:
    int x_depth, y_depth;
    TreeNode* x_parent;
    TreeNode* y_parent;
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root,x,y,0,NULL);
        return (x_depth==y_depth && x_parent!=y_parent);   
    }
    void dfs(TreeNode* root,  int x, int y, int depth, TreeNode* parent)
    {
        //base
        if(root==NULL)
            return;
        
        //logic
        if(x==root->val)
        {
            x_depth = depth;
            x_parent = parent;
        }
        
        if(y==root->val)
        {
            y_depth = depth;
            y_parent = parent;
        }
        dfs(root->left, x,y,depth+1, root);
        dfs(root->right, x,y,depth+1, root);
    }
};
