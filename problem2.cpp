// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    int d1,d2;
    TreeNode* p1,*p2;

    void solve(TreeNode* root,int depth,TreeNode* parent,int x,int y){
        if(!root)
        return ;

        depth+=1;
        parent=root;

        if(root->left){
            if(root->left->val==x){
            d1=depth;
            p1=root;
            return;
            } else if(root->left->val==y){
                d2=depth;
                p2=root;
            } else
                solve(root->left,depth,parent,x,y);
            

        }

        if(root->right){
            if(root->right->val==y){
            d2=depth;
            p2=root;
            return;
            } else if(root->right->val==x){
            d1=depth;
            p1=root;
            return;
            } else
                solve(root->right,depth,parent,x,y);
            

        }        
    }

    bool isCousins(TreeNode* root, int x, int y) {
        solve(root,0,NULL,x,y);
        if(d1==d2 and p1!=p2)
        return 1;

        return 0;
        
    }
};