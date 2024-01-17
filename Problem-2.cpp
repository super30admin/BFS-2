// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: BFS Level order traversal using queue, checking if every element
// in the queue is the x or y and also checking if x and y belong to same parent,
// if so return false. (Same level, different parent).

//993. Cousins in Binary Tree

#include <bits/stdc++.h>
using namespace std;

// Definition for a binary tree node.
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int qSize = q.size();
            bool x_found = false;
            bool y_found = false;
            for(int i = 0;i < qSize;i++){
                TreeNode* curr = q.front();
                q.pop();
                if(curr->val == x){
                    x_found = true;
                }
                if(curr->val == y){
                    y_found = true;
                }
                if(curr->left != NULL && curr->right != NULL){
                    if(curr->left->val == x && curr->right->val == y) return false;
                    if(curr->left->val == y && curr->right->val == x) return false;
                }
                if(curr->left != NULL){
                    q.push(curr->left);
                }
                if(curr->right != NULL){
                    q.push(curr->right);
                }
            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return false;
    }
};