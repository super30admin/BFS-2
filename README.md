# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

class Solution {
public:
    vector<int> ans;
    void rightView(TreeNode *root, int level, int *maxLevel){
        if(root){
            if(level>*maxLevel){
                ans.push_back(root->val);
                *maxLevel = level;
            }
            rightView(root->right, level+1, maxLevel);
            rightView(root->left, level+1, maxLevel);
        }
    }
    vector<int> rightSideView(TreeNode* root) {
        int highest_level = 0;
        rightView(root, 1, &highest_level);
        return ans;
    }
};

## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)


Not working on leetcode

class Solution {
    private int findDepth(TreeNode root, int x)
    {
        
        // Base case
        if (root == null)
            return -1;

        // Initialize distance as -1
        int dist = -1;

        // Check if x is current node=
        if ((root.val == x)|| 
        
            // Otherwise, check if x is
            // present in the left subtree
            (dist = findDepth(root.left, x)) >= 0 || 
            
            // Otherwise, check if x is
            // present in the right subtree
            (dist = findDepth(root.right, x)) >= 0)

            // Return depth of the node
            return dist + 1;
            
        return dist;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int h1 = findDepth(root, x);
        int h2 = findDepth(root, y);

        if (h1 == h2)
            return true;

        return false;
    }
}

