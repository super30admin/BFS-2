// Time Complexity : O(n)
// Space Complexity : O(n) - queue aux. data structure BFS, O(h) height of tree DFS
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
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL)
            return false;
        
        queue<TreeNode*> q1;
        q1.push(root);
            
        while(!q1.empty()){
            int size = q1.size();
            bool x_found = false;
            bool y_found = false;
            for(int i = 0; i < size; i++){
                TreeNode* curr = q1.front();
                q1.pop();
                if(curr->val == x)
                    x_found = true;
                
                if(curr->val == y)
                    y_found = true;
                
                if(curr->left != NULL && curr->right != NULL){
                    if(curr->left->val == x && curr->right->val == y)
                        return false;
                    
                    if(curr->left->val == y && curr->right->val == x)
                        return false;
                }
                
                if(curr->left != NULL)
                    q1.push(curr->left);
                
                if(curr->right != NULL)
                    q1.push(curr->right);
            }
            
            if(x_found && y_found)
                return true;
            
            if(x_found || y_found)
                return false;
        }
        return false;
    }
};


// DFS

class Solution {
    int x_parent; int y_parent;
    int x_depth; int y_depth;
public:
    bool isCousins(TreeNode* root, int x, int y) {
        
        if(root == NULL || root->val == x || root->val == y)
            return false;
        
        dfs(root, NULL, 0, x, y);
        
        return x_parent != y_parent && x_depth == y_depth;
    }
    
    void dfs(TreeNode* root, TreeNode* parent, int level, int x, int y) {
        
        if(root == NULL)
            return;
        
        if(root->val == x){
            x_parent = parent->val;
            x_depth = level;
        }
        
        if(root->val == y){
            y_parent = parent->val;
            y_depth = level;
        }
        
        dfs(root->left, root, level + 1, x, y);
        dfs(root->right, root, level + 1, x, y);
    }
};