// Time Complexity                              :  O(n)
// Space Complexity                             :  O(1)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;

// https://leetcode.com/problems/binary-tree-right-side-view/

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
private:
    vector<vector<int>> lnodes;
public:
    vector<int> rightSideView(TreeNode *root) {
        if(!root) return vector<int>();
        
        // Either get height of tree to construct the 2D array or use c++ constructs as in line 66, 67 or 47,48.
        int h = getHeightOfTree(root);
        lnodes.resize(h,vector<int>());
        
        // levelOrderTraversalRecursive(root, 0);
        levelOrderTraversalIterative(root); 
        
        vector<int> ans;
        for(auto vec : lnodes) {
            ans.push_back(vec[vec.size()-1]);
        }
        
        return ans;
    }
    
    void levelOrderTraversalRecursive(TreeNode *root, int level) {
        if(!root) return;
        
        while(lnodes.size() <= level) {
            lnodes.push_back(vector<int>());
        }
        
        lnodes[level].push_back(root->val);
        levelOrderTraversalRecursive(root->left,level+1);
        levelOrderTraversalRecursive(root->right,level+1);
    }
    
    void levelOrderTraversalIterative(TreeNode *root) {
        if(!root) return;
        
        queue<TreeNode*> q;
        q.push(root);
        int level = 0;
    
        while(!q.empty()) {
            
            int sz = q.size();
            // if(lnodes.size() <= level) 
            //     lnodes.push_back(vector<int>());
            
            for(int i=0;i<sz;i++) {
                
                TreeNode *top = q.front();
                q.pop();
                lnodes[level].push_back(top->val);
                
                if(top->left)
                    q.push(top->left);
                if(top->right)
                    q.push(top->right);
                
            }
            
            level++;
            
        }
    }
    
    // calculate height to create a 2d array of size = height of the tree
    int getHeightOfTree(TreeNode *root) {
        if(!root) return 0;
        
        int l = getHeightOfTree(root->left) + 1;
        int r = getHeightOfTree(root->right) + 1;
        
        return max(l,r);
        
    }
};