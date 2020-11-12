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

// using DFS
// Time complexity is O(n) - n = #treenodes
// Space complexity is O(n) - recursive stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    TreeNode* x_parent, *y_parent;
    int x_depth = -1;
    int y_depth = -1;
    
    bool dfs(TreeNode* node, TreeNode* parent, int depth, int x, int y) {
        //base
        if(node == nullptr) return true;
        //logic
        if(node->val == x) {
            x_parent = parent;
            x_depth = depth;
            if(y_depth >= 0) {
                if((x_parent != y_parent) && (x_depth == y_depth)) return true;
                else return false;
            }
        }
        if(node->val == y) {
            y_parent = parent;
            y_depth = depth;
            if(x_depth >= 0) {
                if((x_parent != y_parent) && (x_depth == y_depth)) return true;
                else return false;
            }
        }
        return dfs(node->left, node, depth+1, x, y) && dfs(node->right, node, depth+1, x, y);
    }
    
    bool isCousins(TreeNode* root, int x, int y) {
        return dfs(root, nullptr, 0, x, y); 
    }
};

// using BFS
// Time complexity is O(n) - n = #treenodes
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()) {
            int size = q.size();
            bool x_found = false;
            bool y_found = false;
            for(int i = 0; i < size; i++) {
                TreeNode* currNode = q.front();
                q.pop();
                if(currNode->val == x) x_found = true;
                if(currNode->val == y) y_found = true;
                if(currNode->left && currNode->right) {
                    if((currNode->left->val == x && currNode->right->val == y)
                    ||(currNode->left->val == y && currNode->right->val == x)) {
                        return false;
                    }
                }
                
                if(currNode->left) q.push(currNode->left);
                if(currNode->right) q.push(currNode->right);
            }
            if(x_found && y_found) return true;
        }
        return false;
    }
};
