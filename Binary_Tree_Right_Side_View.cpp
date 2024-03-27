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
Leetcode : https://leetcode.com/problems/binary-tree-right-side-view/description/

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
*/

/**
 * Approach 1 : BFS approach
 * 
 * Queue is used to store the nodes.
 * Size of queue gives the nodes at same level.
 * LAst node is the queue is the righ most element.
 * 
 * Watch vide for more understanding : https://www.youtube.com/watch?v=tYNauGZDhZI
 * 
*/

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int>result;
        if(root == nullptr) return result;

        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode* temp = q.front();
                q.pop();
                if(i == size-1) result.push_back(temp->val);

                if(temp->left != nullptr) q.push(temp->left);
                if(temp->right != nullptr) q.push(temp->right);
            }
        }
        return result;
    }
};


/**
 * Approach 2 : Using DFS
 * 
 * Recursion is used. Right nodes are visited first in each iteration.
 * Local variable level is used to track the level of the tree.
 * If level is visited first then that node is added to result.
 * 
*/


class Solution {
    vector<int>result;
public:
    vector<int> rightSideView(TreeNode* root) {
        helper(root, 0);
        return result;
    }

    void helper(TreeNode* root, int level){
        if(root == nullptr) return;

        // if size of result is equal to level that ,eans new level of nodes has started to visit, first node visited in each level are added in result.
        if(level == result.size()){
            result.push_back(root->val);
        }
        // right nodes are visited first, so that right view can be seen
        // if left view is asked then visit left node first
        helper(root->right, level+1);
        helper(root->left, level+1);

        return;
    }
};