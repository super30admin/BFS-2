// # Binary Tree Right Side View


// # Did this code successfully run on Leetcode : Yes
// # Any problem you faced while coding this : No
// # Your code here along with comments explaining your approach
// # Approach
// """
// Using Recursive DFS approach in which traversing the tree level by level 
// starting from rightmost child and if level and size are same than add the element 
// to the stack maintained.


//Idea- Level order - DFS
//// # Time Complexity : O(n)
// # Space Complexity : O(h), h is the height of the tree

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
    
    vector<int> result; //global
    
    vector<int> rightSideView(TreeNode* root) {
             
        if(root==NULL){
            return result;
        }
        
        dfs( root, 0);
        return result;
    }
    
    void dfs( TreeNode* root, int level){
        if(root ==NULL){
            return;
        }
        
        if( level == result.size()){
            result.push_back(root->val);
        }
        // result[level]=root->val;
        
        
       
        dfs(root->right, level+1);
        dfs(root->left, level+1);
    }
};


//Idea- Level order - BFS
// # Time Complexity : O(n)
// # Space Complexity : O(n)
// # Approach
// """
//use BFS and store the last right most node's value in output list

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
        
    if(root==NULL){
        return result;
    }
        
    queue<TreeNode* > q1;
    q1.push(root);
        
    while(!q1.empty()){
        
        int size= q1.size();
        
        for(int i=0 ; i< size; i++){
            
            
            TreeNode* ele= q1.front();
            q1.pop();
            
            
            if(i== size-1){
                // cout<< "ele" << ele->val << " " << i << " " << size<<endl;
                result.push_back(ele->val);
            }
            
            if(ele->left!=NULL){
                q1.push(ele->left);
            }
            
            if(ele->right!=NULL){
                q1.push(ele->right);
            }
        }
    }
    
    return result;
    }
};