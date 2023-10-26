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
TreeNode* parent_x;
TreeNode* parent_y;    
int depth_x;
int depth_y;    
public:
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root, NULL, x, y, 0);
        return (parent_x!=parent_y && depth_x==depth_y);
    }
private: 
    void dfs(TreeNode*root, TreeNode*parent, int x, int y, int depth){
        //base
        if(root==NULL)return;
        //logic
        if(root->val==x){
            depth_x=depth;
            parent_x=parent;
        }
        if(root->val==y){
            depth_y=depth;
            parent_y=parent;
        }
        dfs(root->left, root, x, y, depth+1);
        dfs(root->right, root, x, y, depth+1);
    }    
};
/*
Conditional recursion:
class Solution {
TreeNode* parent_x;
TreeNode* parent_y;    
int depth_x;
int depth_y;    
public:
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root, NULL, x, y, 0);
        return (parent_x!=parent_y && depth_x==depth_y);
    }
private: 
    void dfs(TreeNode*root, TreeNode*parent, int x, int y, int depth){
        //base
        if(root==NULL)return;
        //logic
        if(root->val==x){
            depth_x=depth;
            parent_x=parent;
        }
        if(root->val==y){
            depth_y=depth;
            parent_y=parent;
        }
        if(parent_x==NULL || parent_y==NULL){ // here we see if we found x or y, if we havent then only we go for finding them
            dfs(root->left, root, x, y, depth+1);
        }
        if(parent_x==NULL || parent_y==NULL){
            dfs(root->right, root, x, y, depth+1);
        }
    }    
};
*/
/*
 //BFS Solution
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            bool x_found = false;
            bool y_found = false;
            for(int i=0;i<size;i++){
                TreeNode* curr = q.front();
                q.pop();
                if(curr->val==x)x_found = true;
                if(curr->val==y)y_found = true;
                if(curr->left!=NULL && curr->right!=NULL){
                    if(curr->left->val==x && curr->right->val==y)return false;
                    if(curr->left->val==y && curr->right->val==x)return false;
                }
                if(curr->left!=NULL)q.push(curr->left);
                if(curr->right!=NULL)q.push(curr->right);
            }
            if(x_found && y_found)return true;
            if(x_found || y_found)return false;
        }
        return true;
    }
};
*/
