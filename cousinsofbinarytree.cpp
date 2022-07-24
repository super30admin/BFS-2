//TC-O(N)
//SC-O(H)
class Solution {
public:
    int xheight;
    int yheight;
    TreeNode* xparent;
    TreeNode* yparent;
    bool helper(TreeNode* root, TreeNode* parent,int level,int x, int y){
      if(!root)return false;
        if(root->val==x){
            xheight=level;
            xparent=parent;
        }
        if(root->val==y){
            yheight=level;
            yparent=parent;
        }
        helper(root->left,root,level+1,x,y);
        helper(root->right,root,level+1,x,y);
        
        if(xheight==yheight&&xparent!=yparent)return true;
        else return false;
    }
    bool isCousins(TreeNode* root, int x, int y) {
if(!root||x==y)return false;
        return helper(root,NULL,0,x,y);
    }
};