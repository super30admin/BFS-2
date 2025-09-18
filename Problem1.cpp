// Problem : Right side view of tree
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this :  No

// Your code here along with comments explaining your approach in three
// sentences only
// 1. Traverse level by level and add the last node of the current level to our
// result
// 2. This is BFS traversal and in the end we return the result

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
  vector<int> rightSideView(TreeNode *root) {
    vector<int> res;
    if (!root)
      return res;
    queue<TreeNode *> q;
    q.push(root);

    while (!q.empty()) {
      int size = (int)q.size();
      for (int i = 0; i < size; i++) {
        auto front = q.front();
        q.pop();
        if (i == size - 1) {
          res.push_back(front->val);
        }
        if (front->left)
          q.push(front->left);
        if (front->right)
          q.push(front->right);
      }
    }

    return res;
  }
};
