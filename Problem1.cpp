// Time Complexity : O(N) N is #of nodes in tree
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse tree using DFS while taking level variable globally which will increase while traversing left than right and decrease after completing traversal.
// 2. In tree if node is not visited add it to array with index same as level. 
// 3. Even if element is already present replace it with current traversing node. Return array.

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
    int s=1;
    vector<int> dfs(TreeNode* t,vector<int> &ans){
        s++;
        if((t->left)!=nullptr){ 
            if(ans.size()<s ){
                ans.push_back(t->left->val);
            }else{
                ans[s-1]=(t->left->val);
            }
            dfs(t->left,ans); s--;
        
        }
        if((t->right)!=nullptr){ 
            if(ans.size()<s ){
                ans.push_back(t->right->val);
            }
            else{
                ans[s-1]=(t->right->val);
            }
            dfs(t->right,ans); s--;}
        
        return ans;

    }
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ans;
        if(root==nullptr){return ans;}
        ans.push_back(root->val);
        return dfs(root,ans);
    }
};