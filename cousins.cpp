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
//T : O(n);
//S: O(n);
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> qu;
        qu.push(root);
        map<int, int> depths;
        map<int, int> parents;
        depths[root->val] = 0;
        while(!qu.empty()){
            TreeNode* xy = qu.front(); qu.pop();
            //cout<<xy->left->val<<endl;
            if(xy->left) {qu.push(xy->left);depths[xy->left->val] = depths[xy->val]+1; parents[xy->left->val]=xy->val;}
            if(xy->right) {qu.push(xy->right);depths[xy->right->val] = depths[xy->val]+1; parents[xy->right->val]=xy->val;}
        }
        //cout<<depths[x]<<" "<<depths[y]<<" && "<<parents[x]<<" "<<parents[y]<<endl;
        if(depths[x]==depths[y] && parents[x]!=parents[y]) return true;
        return false;
        
    }
};