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
    int xlevel = 0;
    int ylevel = 0;
    TreeNode *xparents = NULL;
    TreeNode *yparents = NULL;
    bool isCousins(TreeNode* root, int x, int y) {
        
        if(root == NULL) return false;
          dfs(root,NULL,0,x,y);
       
        return xlevel==ylevel && xparents != yparents;
    }
    
    void dfs(TreeNode *root, TreeNode *parent,int level,int x,int y) {
        
        if(root == NULL)  return;
        
        dfs(root->left, root,level+1,x,y);
        dfs(root->right,root,level+1,x,y);
        
        if(x == root->val) {
            xlevel = level;
            xparents = parent;
        }
        
         if(y == root->val){
            ylevel = level;
            yparents = parent;
        }
    }
};