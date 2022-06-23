
// Time Complexity : O(n)
// Space Complexity : O(h) dfs , forx and fory vectors have constant space of O(2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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
public:
    
    void isCousinsRecur( TreeNode* root, int x, int y,int parent, int depth, vector<int> &forx, vector<int> &fory ){
        if( root == nullptr ){
            return;
        }
        
        if( root->val == x ){
            forx.push_back( parent ); // parent
            forx.push_back( depth ); // depth 
        }
        if( root->val == y ){
            fory.push_back( parent ); // parent
            fory.push_back( depth ); // depth 
        }
        
        isCousinsRecur( root->left, x, y, root->val, depth + 1, forx, fory);
        isCousinsRecur( root->right, x, y, root->val, depth + 1, forx, fory);
    }
    
    
    bool isCousins(TreeNode* root, int x, int y) {
        int parent= 0;
        //bool flag = false;
        int depth = 0;
        vector<int>forx;
        vector<int>fory;
        isCousinsRecur( root, x, y, parent, depth, forx, fory );
        if( forx[0] != fory[0] && forx[1] == fory[1]){
            return true;
        }
        return false;
        
    }
};
