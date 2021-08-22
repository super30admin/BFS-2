// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//DFS(method 1)
class Solution {
public:
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL){
            vector<int> x;
            return x;
        }
        dfs(root, 0);
        return result;
    }
    
    void dfs(TreeNode* root, int level){
        if(root == NULL){
            return;
        }
        int size = result.size();
        if(level == size){
            result.push_back(root->val);
        }
        dfs(root->right,level+1);
        dfs(root->left, level+1);
    }
};

// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//DFS(method 2)
class Solution {
public:
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL){
            vector<int> x;
            return x;
        }
        dfs(root, 0);
        return result;
    }
    
    void dfs(TreeNode* root, int level){
        if(root == NULL){
            return;
        }
        int size = result.size();
        if(level == size){
            result.push_back(root->val);
        }
        result[level] = root->val;
        dfs(root->left,level+1);
        dfs(root->right, level+1);
    }
};

// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//BFS
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
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL){
            vector<int> x;
            return x;
        }
        vector<int> result;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode* curr = q.front();
                q.pop();
                if(i == size-1){
                    result.push_back(curr->val);
                }
                if(curr->left != NULL)
                    q.push(curr->left);
                if(curr->right != NULL)
                    q.push(curr->right);
            }
            size++;
        }
        return result;
    }
};
