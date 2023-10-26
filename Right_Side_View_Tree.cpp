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
        vector<int> result;
        if(root==NULL)return result;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                TreeNode* curr = q.front();
                q.pop();
                if(i==size-1){ // here if we keep i==0, we will get the left side view of the tree
                    result.push_back(curr->val);
                }
                if(curr->left!=NULL){
                    q.push(curr->left);
                }
                if(curr->right!=NULL){
                    q.push(curr->right);
                }
            }
        }
     return result;   
    }
};

/*
 //dfs solution
class Solution {
public:
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        dfs(root, 0);
        return result;
        }
private:
    void dfs(TreeNode*root, int level){
        if(root==NULL)return;
        if(level==result.size()){
            result.push_back(root->val);
        }
       //left view:
        //dfs(root->left, level+1);
        //dfs(root->right, level+1);
        //right view
        dfs(root->right, level+1);
        dfs(root->left, level+1);
    }        
};

*/
/*
Another approach for DFS Right View
 //dfs solution
class Solution {
public:
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        dfs(root, 0);
        return result;
        }
private:
    void dfs(TreeNode*root, int level){
        if(root==NULL)return;
        if(level==result.size()){
            result.push_back(root->val);
        }
        else{
            result[level]=root->val; // here we introduced this to updte the values so that whenever we are at the end node of a level, it gets into the result
        }
       //left view:
        //dfs(root->left, level+1);
        //dfs(root->right, level+1);
        //right view
        dfs(root->left, level+1);
        dfs(root->right, level+1);
        
    }        
};
*/
