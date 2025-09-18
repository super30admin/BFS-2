// Problem : Cousins tree
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this :  No

// Your code here along with comments explaining your approach in three
// sentences only
// 1. Traverse level by level and check if the current node's children are not x
// and y, if yes return false;
// 2. Else add them to queue and if both of them found, that means they are on
// same level, return true
// 3. If one of them is found, not the same depth, return false;

#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

class Solution {
public:
  bool isCousins(TreeNode *root, int x, int y) {
    // same depth and not the same parent
    queue<TreeNode *> q;
    q.push(root);
    bool dx_found = false;
    bool dy_found = false;
    while (!q.empty()) {
      int size = (int)q.size();
      for (int i = 0; i < size; i++) {
        auto front = q.front();
        q.pop();
        if (front->left && front->right) {
          // if belong to the same parent and have values equal to x and y,
          // return immediately
          if (front->left->val == x && front->right->val == y) {
            return false;
          }
          if (front->left->val == y && front->right->val == x) {
            return false;
          }
        }
        if (front->val == x) {
          dx_found = true;
        }
        if (front->val == y) {
          dy_found = true;
        }
        if (front->left) {
          q.push(front->left);
        }
        if (front->right) {
          q.push(front->right);
        }
      }
      if (dy_found && dx_found)
        return true;
      // if one of them is found, that means not equal depth
      if (dy_found || dx_found)
        return false;
    }

    return false;
  }
};
