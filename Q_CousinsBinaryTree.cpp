// # Cousins in a binary tree

// # Time Complexity : O(n)
// # Space Complexity : O(n)
// # Did this code successfully run on Leetcode : Yes 
// # Any problem you faced while coding this : No
// # Your code here along with comments explaining your approach
// # Approach
// """
// The two conditions for returning true for cousins is both at same level 
// but different Parents. Using DFS recursive approach a Stack is maintained
// which stores level. 


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
    int x_lvl, y_lvl;
    int x_parent, y_parent;
    bool isCousins(TreeNode* root, int x, int y) {
        
        if(root==NULL){
            return true;
        }
        
        dfs(root, NULL, 0, x, y);
        return x_lvl== y_lvl && x_parent!= y_parent;
        
    }
    
    void dfs( TreeNode* root, TreeNode* parent, int level, int x, int y){
        if(root==NULL){
            return ;
        }
        
        if(root->val ==x){
            x_lvl = level;
            if(parent!=NULL)
                x_parent = parent->val;
        }
        
        if(root->val ==y){
            y_lvl = level;
            if(parent!=NULL)
                y_parent = parent->val;
        }
        
        dfs(root->left, root, level+1, x, y);
        dfs(root->right, root, level+1, x, y);
    }
};