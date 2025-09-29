// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(h), h = height of tree, which would be O(n) in worst case (skewed tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Traverse the tree using DFS, track the x parent, x level, y parent and y level (pass by reference or global params)
// At a level, check if the current nodes' children are either x or y, track the level and parents accordingly
// Early stop if xP and yP are != -1 (both nodes found already)

class Solution {
private:
    void dfs(TreeNode* root, int x, int y, int level, int& xP, int& yP, int& xL, int& yL) {
        // base:
        if(!root) return;

        if(xP != -1 && yP != -1) return;

        // logic:
        if((root->left && root->left->val == x) || (root->right && root->right->val == x)) {
            xP = root->val;
            xL = level + 1;
        }
        if((root->left && root->left->val == y) || (root->right && root->right->val == y)) {
            yP = root->val;
            yL = level + 1;
        }

        dfs(root->left, x, y, level + 1, xP, yP, xL, yL);
        dfs(root->right, x, y, level + 1, xP, yP, xL, yL);
    }
public:
    bool isCousins(TreeNode* root, int x, int y) {
        int xP = -1; int yP = -1;
        int xL = -1; int yL = -1;
        dfs(root, x, y, 0, xP, yP, xL, yL);

        return xP != yP && xL == yL;
    }
};