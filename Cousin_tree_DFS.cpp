Time Complexity-O(n)
Space Complexity-O(1) if recurive stack space is not considered or else it is O(h)

class Solution {
public:
    int level_x=-1;
    int level_y=-2;
    int parent_x=-1;
    int parent_y=-1;
    bool isCousins(TreeNode* root, int x, int y) {
        int level=0;
        findcousins(root,x,y,level);
        if(level_x==level_y && parent_x!=parent_y)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    void findcousins(TreeNode* root, int x,int y, int level)
    {
        if(root==NULL)
        {
            return;
        }
        if(root->left!=NULL && root->left->val==x || root->right!=NULL && root->right->val==x)
        {
            parent_x=root->val;
            level_x=level;
        }
        if(root->left!=NULL && root->left->val==y || root->right!=NULL && root->right->val==y)
        {
            parent_y=root->val;
            level_y=level;
        }
        findcousins(root->left,x,y,level+1);
        findcousins(root->right,x,y,level+1);
    }
};