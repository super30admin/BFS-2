// Time Complexity :  O(N)
// Space Complexity :  O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    // BFS, TC = O(N), SC = O(N) // q if leaf level has n / 2 nodes
// public:
//     vector<int> result;
//     vector<int> rightSideView(TreeNode* root) {
//         // null
//         if(root == nullptr) return result;
//         queue<TreeNode*> q;
//         q.push(root);
//         while(!q.empty()) {
//             int size = q.size();
//             for(int i = 0; i < size; i++) {
//                 TreeNode* curr = q.front();
//                 q.pop();
//                 if(i == size - 1) result.push_back(curr->val);
//                 if(curr->left != nullptr) q.push(curr->left);
//                 if(curr->right != nullptr) q.push(curr->right);
//             }
//         }
//         return result;
//     }

    // DFS, TC = O(N), SC = O(H) // recursive stack space
public:
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        // null
        if(root == nullptr) return result;
        dfs(root, 0);
        return result;
    }
private:
    void dfs(TreeNode* root, int level) {
        // base
        if(root == nullptr) return;
        // logic
        if(level == result.size()) result.push_back(root->val);
        // calling right first as it is right side view
        dfs(root->right, level + 1);
        dfs(root->left, level + 1);
        // if we are calling left first then we have to replace in the result like this
        // result.insert(level, root.val);
    }
};