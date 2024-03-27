// Apporach 1 
// Time Complexity : O(n) ...... N is total number of elements in tree
// Space Complexity : O(n/2) == O(n) ...... Because of use of Queue; maximum elements in queue will be
//                                   ...... elements from last level (leaf nodes) which is n/2
//
// Apporach 2
// Time Complexity : O(n) ...... N is total number of elements in tree
// Space Complexity : O(h) == worst case O(n) skewed tree ...... Because of use of stack in recursion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/cousins-in-binary-tree/description/

Given the root of a binary tree with unique values and the values of two different
nodes of the tree x and y, return true if the nodes corresponding to the values x and y 
in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins if they have the same depth with different parents.
Note that in a binary tree, the root node is at the depth 0, and children of each depth k
 node are at the depth k + 1.
*/


/**
 * 
 * Approach 1 : BFS
 * 
 * Watch vide for more understanding : https://www.youtube.com/watch?v=tYNauGZDhZI
 * 
*/

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == nullptr) return false;

        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()){
            int size = q.size();
            bool x_found = false;
            bool y_found = false;

            for(int i=0; i<size; i++){
                TreeNode* temp = q.front();
                q.pop();

                if(temp->val == x) {
                    x_found = true;
                }
                if(temp->val == y) {
                    y_found = true;
                }

                if(temp->left != nullptr && temp->right != nullptr){
                    if(temp->left->val == x && temp->right->val == y) return false;
                    if(temp->right->val == x && temp->left->val == y) return false;
                }

                if(temp->left != nullptr){
                    q.push(temp->left);
                }
                if(temp->right != nullptr){
                    q.push(temp->right);
                }

            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return false;
    }
};

/*
 * 
 * Approach 2 : DFS
 * 
 * Watch vide for more understanding : https://www.youtube.com/watch?v=tYNauGZDhZI
 * 
*/


class Solution {
    TreeNode* x_parent;
    TreeNode* y_parent;
    int x_level;
    int y_level;
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == nullptr) return false;
        dfs(root, 0, nullptr, x, y);
        return ((x_level == y_level) && (x_parent != y_parent));
    }

    void dfs(TreeNode* root, int level, TreeNode* parent, int x, int y){
        if(root == nullptr) return;

        if(root->val == x){
            x_level = level;
            x_parent = parent;
        }
        if(root->val == y){
            y_level = level;
            y_parent = parent;
        }
        dfs(root->left, level+1, root, x, y);
        dfs(root->right, level+1, root, x, y);
    }
};