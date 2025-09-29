// Time Complexity : O(n)
// Space Complexity : O(h), which will be O(n) in the worst case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We recursively travel over the entire tree, first going to the right side and then the left side
// We push the first node we encounter in our right-left traversal as this will be the rightmost ndoe
// Return the populated result vector in the end

class Solution {
private:
    void helper(TreeNode* root, int level, vector<int>& result) {
        // base case:
        if(!root) return;
        // logic:
        if(level == result.size()) {
            result.push_back(root->val);
        }
        helper(root->right, level + 1, result);
        helper(root->left, level + 1, result);
    }
public:
    vector<int> rightSideView(TreeNode* root) {
        if(!root) return {};
        vector<int> result;
        helper(root, 0, result);
        return result;
    }
};