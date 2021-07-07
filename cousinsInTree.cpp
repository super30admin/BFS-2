// Time Complexity : O(n)
// Space Complexity : O(n/2) i.e. O(n); 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Do it similar to level order using BFS and set two bool variables to false in each for loop iteration
// 2. When a node is popped out, check if its children are given as x and y; if yes return false as they are siblings not cousins
// 3. If a node equals x or y, make the corr bool = true. When both bools are true, return true

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == nullptr)
            return true;
        queue<TreeNode*> q;
        q.push(root);
        int size = 0;
        bool foundX = false, foundY = false;
        while(!q.empty()){
            size = q.size();
            for(int i=0;i<size;i++){
                auto curr = q.front(); q.pop();
                // checking for the case when given x and y are siblings
                if(curr->left && curr->right){
                    if(curr->left->val == x && curr->right->val == y)
                        return false;
                    if(curr->left->val == y && curr->right->val == x)
                        return false;
                }
                // checking if curr node is either of the two
                if(curr->val == x)
                    foundX = true;
                if(curr->val == y)
                    foundY = true;
                // if both found 
                if(foundX && foundY)
                    return true;
                
                // not found at this level, add next level 
                if(curr->left)
                    q.push(curr->left);
                if(curr->right)
                    q.push(curr->right);
            }
            // reset at end of each level since cousins need to be at same level
            foundX = false;
            foundY = false;
        }
        return false;
    }
};