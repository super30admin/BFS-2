// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//DFS
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
    TreeNode *x_parent, *y_parent;
    int x_depth, y_depth;
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL){
            return false;
        }
        dfs(root, x, y, 0, NULL);
        return (x_depth == y_depth && x_parent != y_parent);
    }
    void dfs(TreeNode* root, int x, int y, int lvl, TreeNode* parent){
        //base
        if(root == NULL)
            return;
        //logic
        if(root->val == x){
            x_parent = parent;
            x_depth = lvl;
        }
        if(root->val == y){
            y_parent = parent;
            y_depth = lvl;
        }
        dfs(root->left, x, y, lvl+1, root);
        dfs(root->right, x, y, lvl+1, root);
    }
    
};


//DFS optimization
class Solution {
public:
    TreeNode *x_parent, *y_parent;
    int x_depth, y_depth;
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL){
            return false;
        }
        dfs(root, x, y, 0, NULL);
        return (x_depth == y_depth && x_parent != y_parent);
    }
    void dfs(TreeNode* root, int x, int y, int lvl, TreeNode* parent){
        //base
        if(root == NULL)
            return;
        if(x_parent != NULL && y_parent != NULL) //bcoz they are set only when x and y is found.
            return;
        //logic
        if(root->val == x){
            x_parent = parent;
            x_depth = lvl;
        }
        if(root->val == y){
            y_parent = parent;
            y_depth = lvl;
        }
        dfs(root->left, x, y, lvl+1, root);
        dfs(root->right, x, y, lvl+1, root);
    }
    
};


// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL){
            return false;
        }
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            bool x_found = false;
            bool y_found = false;
            for(int i=0; i<size; i++){
                TreeNode* curr = q.front();
                q.pop();
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
                    q.push(curr->left);
                if(curr->right != NULL)
                    q.push(curr->right);
            }
            if(x_found && y_found)
                return true;
            if(x_found || y_found)
                return false;
        }
        return false;
    }
    
    
};
