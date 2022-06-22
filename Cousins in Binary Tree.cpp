//Time Complexity- O(n)
//Space Complexity- O(h) (Recursive Stack)

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        
        int xHeight,yHeight;
        TreeNode* xParent;
        TreeNode* yParent;
        dfs(root,NULL,x,y,xParent,yParent,xHeight,yHeight,0);
        return xParent!=yParent && xHeight==yHeight;
    }
    
    void dfs(TreeNode* root,TreeNode* parent,int x,int y,TreeNode* &xParent,TreeNode* &yParent,int &xHeight,int &yHeight,int level){
        
        if(root==NULL){
            return;
        }
        if(root->val==x){
            xParent=parent;
            xHeight=level;
        }
        if(root->val==y){
            yParent=parent;
            yHeight=level;
        }
        dfs(root->left,root,x,y,xParent,yParent,xHeight,yHeight,level+1);
        dfs(root->right,root,x,y,xParent,yParent,xHeight,yHeight,level+1);
    }
};