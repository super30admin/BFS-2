// Time Complexity : O(N) N is #of nodes in tree
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse tree using DFS while taking level variable globally which will increase while traversing left than right and decrease after completing traversal.
// 2. If current node value is x or y store level value in a,b respectively.Also while traversing if both childs are x and y flag it and return. 
// 3. If a!=b or it is flagged return false else true.

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
    int s=1,a=0,b=0,f=1;
    void dfs(TreeNode* t,int x,int y){
        if(t==nullptr){
            return;
        }
        
        if((t->val)==x){
            a=s;
        }
        if((t->val)==y){
            b=s;
        }
        
        if(t->left!=nullptr && t->right!=nullptr 
        && ( (t->left->val == x && t->right->val==y ) 
        || (t->left->val == y && t->right->val==x ) ) ){
            f=0;return;
        }
        s++;
        dfs(t->left,x,y);
        dfs(t->right,x,y);
        s--;
    }
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root,x,y);
        if(a!=b || f==0){
            return 0;
        }
        return 1;
    }
};