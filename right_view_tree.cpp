// Time Complexity : O(N) where N represents the no.of nodes in the tree
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/binary-tree-right-side-view/
// Submission Link: https://leetcode.com/submissions/detail/542456000/

class Solution {
    vector<int> result;
    int maxDepth;
public:
    vector<int> rightSideView(TreeNode* root) {
        result = {};
        maxDepth = -1;
        
        helper(root, 0);
        return result;
    }
    
    void helper(TreeNode* root, int depth){
        if(root == NULL)
            return;
        
        if(depth > maxDepth){
            result.push_back(root -> val);
            maxDepth = depth;
        }
        
        helper(root -> right, depth + 1);
        helper(root -> left, depth + 1);
    }
};