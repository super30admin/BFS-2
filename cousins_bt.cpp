// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Recursive solution
// Time Complexity : O(n) 
// Space Complexity : O(h) in worst case then O(n).
//DFS solution
//Recursive:
//1. Call recursion on the left node of the root till null condition is met 
//2. Save the result at each level for the x and y variables
//3. return and chek the levels and parents value
//BFS
// Time Complexity : O(n)
// Space Complexity :O(n/2).
//1.Create a queue and add elements level by level
//2.Save the last element of the level in the result and return. Inorder to do that size variable is required.
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
    TreeNode *x_parent= new TreeNode();
    TreeNode *y_parent = new TreeNode();
    int x_level = -1, y_level=-1;
    bool isCousins(TreeNode* root, int x, int y) {
        //edge case
        if(root==NULL){
            return false;
        }
        
        //recursion
        //  cousins_check( root,  NULL,  x,  y, 0);
        // return((x_level == y_level) && (x_parent != y_parent));
        
        //BFS
        
        queue<TreeNode*> BFS_queue;
        BFS_queue.push(root);
        
        while(!BFS_queue.empty()){
            int size = BFS_queue.size();
            bool x_found=false, y_found= false;
            while(size>0){
                TreeNode* temp = BFS_queue.front();
                BFS_queue.pop();
                size --;
                if(temp ==NULL){
                    continue;    
                }
                if(temp->val == x) x_found = true;
                if(temp->val == y) y_found = true;
                BFS_queue.push(temp->left);
                BFS_queue.push(temp->right);
                if(temp->right!=NULL && temp->left!=NULL) { // Check for the parents to be different
                    if(temp->right->val ==x && temp->left->val ==y) return false;
                    if(temp->right->val ==y && temp->left->val ==x) return false;
                }
            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        
        return false;
    }
 private: 
    void cousins_check(TreeNode* root, TreeNode* parent, int x, int y, int level){
        //return condition
        if(root==NULL){
            return ;
        }
        if(root->val == x){
            x_level = level;
            x_parent = parent;
        }
        if(root->val == y){
            y_level = level;
            y_parent = parent;
        }
        
        cousins_check( root->left,  root,  x,  y, level+1);
        cousins_check( root->right, root,  x,  y, level+1);
    }
    
};
