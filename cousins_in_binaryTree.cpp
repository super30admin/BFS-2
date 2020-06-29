// Time Complexity :O(N) N-> Number of nodes in the tree
// Space Complexity :O(H) H->Height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Recursion Approach
class Solution {
public:
    TreeNode* pX =NULL,*pY=NULL;
    int heightX = 0, heightY = 0;
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL)
            return false;
        helper(root,NULL,x,y,0);
        return pX!=pY && heightX == heightY;


    }
    void helper(TreeNode* root,TreeNode* parent,int x, int y,int depth){

        //base
        if(root==NULL)
            return;
        // logic
        if(root->val == x) {
            pX = parent;
            heightX = depth;
        }
        if(root->val == y) {
            pY = parent;
            heightY = depth;
        }
        helper(root->left,root,x,y,depth+1);
        helper(root->right,root,x,y,depth+1);
    }

};
