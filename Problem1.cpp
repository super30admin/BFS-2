// Time Complexity : O(n)
// Space Complexity : O(n) - queue aux. data structure 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

 struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };


// BFS 

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        
        if(root == NULL)
            return result;
        
        queue<TreeNode*> q1;
        q1.push(root);
        
        TreeNode *curr = NULL;
        
        while(!q1.empty()){
            
            int size = q1.size();
            for(int i = 0; i < size; i++){
                curr = q1.front();
                if(i == size - 1){
                    result.push_back(curr->val);
                }
                q1.pop();
                if(curr->left != NULL)
                    q1.push(curr->left);
                
                if(curr->right != NULL)
                    q1.push(curr->right);
                
            }
        }
        return result;
    }
};

// DFS

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        if(root == NULL)
            return {};
        
        dfs(root, 0, result);
        return result;
    }
    
    void dfs(TreeNode* root, int level, vector<int> &result){
        if(root == NULL)
            return;
        
        if(level == result.size())
            result.push_back(root->val);
        dfs(root->right, level + 1, result);
        dfs(root->left, level + 1, result);
    }
};