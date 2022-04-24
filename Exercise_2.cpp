// Time Complexity                              :  O(N) where N is the number of nodes
// Space Complexity                             :  O(N) in case of skewed tree, the height will be N hence the
//                                                 space stored in the function stack in recursive method and 
//                                                 space stored in the queue in the iterative method is O(N)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/cousins-in-binary-tree/

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
    // to store for every node the level and parent of the node.
    unordered_map<int,pair<int,int>> mp;
    int xlevel, ylevel, xparent, yparent;
    
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(!root) return true;
        
        // levelOrderIterative(root);
        // return mp[x].first == mp[y].first and mp[x].second != mp[y].second;
        
        levelOrderRecursive(root,0,x,y,-1);
        
        return xlevel == ylevel and xparent != yparent;
    }
    
    void levelOrderIterative(TreeNode *root) {
        if(!root) return;
        
        queue<pair<TreeNode*,int>> q;
        q.push({root,-1});
        
        int level = 0;
        
        while(!q.empty()) {
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                auto [node, parent] = q.front(); q.pop();
                mp[node->val] = {level, parent};
                if(node->left)
                    q.push({node->left, node->val});
                if(node->right)
                    q.push({node->right, node->val});
            }
            level++;
        }
    }
    
    void levelOrderRecursive(TreeNode *root, int level, int x, int y, int parent) {
        if(!root) return;
        
        if(root->val == x) {
            xlevel = level;
            xparent = parent;
        }
        
        if(root->val == y) {
            ylevel = level;
            yparent = parent;
        }
        
        levelOrderRecursive(root->left,level+1,x,y,root->val);
        levelOrderRecursive(root->right,level+1,x,y,root->val);
        
    }
};