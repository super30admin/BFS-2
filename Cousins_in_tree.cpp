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
TreeNode* parent_x;
TreeNode* parent_y;    
int depth_x;
int depth_y;    
public:
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root, NULL, x, y, 0);
        return (parent_x!=parent_y && depth_x==depth_y);
    }
private: 
    void dfs(TreeNode*root, TreeNode*parent, int x, int y, int depth){
        //base
        if(root==NULL)return;
        //logic
        if(root->val==x){
            depth_x=depth;
            parent_x=parent;
        }
        if(root->val==y){
            depth_y=depth;
            parent_y=parent;
        }
        dfs(root->left, root, x, y, depth+1);
        dfs(root->right, root, x, y, depth+1);
    }    
};
