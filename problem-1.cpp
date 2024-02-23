// 199. Binary Tree Right Side View
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
using dfs and keeps track of the maximum level reached so far and adds the value of the first encountered node at each level
to the answer vector, ensuring only the rightmost node at each level is included.

*/

class Solution {
public:
    vector<int> ans;
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return ans;
        dfs(root, 0);
        return ans;
    }
    void dfs(TreeNode* root, int level)
    {
        if(root == NULL) return;

        if(level >= ans.size())
            ans.push_back(root->val);
        
        dfs(root->right, level + 1);
        dfs(root->left, level + 1);
        return;
    }
};