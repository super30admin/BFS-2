// Time Complexity :O(N) where n in the number of nodes
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        int xLevel = 0;
        int yLevel = 0;
        TreeNode *xParent;
        TreeNode *yParent;
        bool xPresent = false;
        bool yPresent = false;
    
public:
    /*bool isCousins(TreeNode* root, int x, int y) {
        //DFS
        dfs(root,nullptr,0,x,y);
        return (xLevel == yLevel) && (xParent != yParent);
    }
    void dfs(TreeNode* root, TreeNode* parent, int level, int x, int y){
        //base
        if(!root) return;
        //logic
        if(root->val == x){
            xLevel = level;
            xParent = parent;
        }
        if(root-> val == y){
            yLevel = level;
            yParent = parent;
        }
        //recursion
        dfs(root->left,root,level+1,x,y);
        dfs(root->right,root,level+1,x,y);
    }*/
    bool isCousins(TreeNode* root, int x, int y){
        //BFS
        int size;
        queue<pair<TreeNode*,TreeNode*>> q;
        pair<TreeNode*,TreeNode*> curr;
        q.push({root,nullptr});
        while(!q.empty()){
            size = q.size();
            for(int i = 0;i< size;i++){
                curr = q.front();
                q.pop();
                if(curr.first->val == x){
                    xPresent = true;
                    xParent = curr.second;
                } 
                if(curr.first->val == y){
                    yPresent = true;
                    yParent = curr.second;
                }
                if(curr.first->left) q.push({curr.first->left,curr.first});
                if(curr.first->right) q.push({curr.first->right,curr.first});
            }
            if(xPresent && yPresent){
                if(xParent != yParent)
                    return true;
            }
            if(xPresent || yPresent) return false;
        }
        return false;
    }
};