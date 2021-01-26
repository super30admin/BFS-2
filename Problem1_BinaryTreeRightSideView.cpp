
// Time Complexity : O(n) where n is number of elements as we are traversing for each element
// Space Complexity : O(n) actually it is 2^h the last row will have worst case scenario n/2 so its O(n)
// Did this code successfully run on Leetcode :yes
// Did this code successfully run on Home Computer :No
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


#include<vector>
#include<bits/stdc++.h>
#include<stdlib.h>
#include<cmath>
#include<time.h>
#include<iostream>

using namespace std;

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

//Below is the BFS Solution

// class Solution {
// public:
//     vector<int> rightSideView(TreeNode* root) {
        
//         queue<TreeNode*> q;
//         q.push(root);
//         vector<int> result;
//         if(root==NULL) return result;
        
//         while(!q.empty()){
//             int size=q.size();
//             for(int i=0;i<size;i++){
//                 TreeNode* curr=q.front();
//                 q.pop();
                
//                 if(i==size-1){
//                     result.push_back(curr->val);
//                 }
//                 if(curr->left != NULL) q.push(curr->left);
//                 if(curr->right != NULL) q.push(curr->right);
                
//             }
//         }
//         return result;
        
        
//     }
// };

// If we are traversing through the right side

// class Solution {
//     vector<int> result;
// public:
//     vector<int> rightSideView(TreeNode* root) {
        
               
//         if(root==NULL) return result;
        
//         dfs(root,0);
//         return result;
        
        
//     }
    
// private:
//     void dfs(TreeNode* root,int depth){
//         //base
//         if(root==NULL) return;
//         //logic
//         if(depth==result.size()){
//             result.push_back(root->val);
//         }
//         dfs(root->right,depth+1);
//         // st.pop();
//         dfs(root->left,depth+1);
        
        
//     }
    
// };

//If we are traversing through the left side

class Solution {
    vector<int> result;
public:
    vector<int> rightSideView(TreeNode* root) {
        
               
        if(root==NULL) return result;
        
        dfs(root,0);
        return result;
        
        
    }
    
private:
    void dfs(TreeNode* root,int depth){
        //base
        if(root==NULL) return;
        //logic
        if(depth==result.size()){
            result.push_back(root->val);
        }else{
            result[depth]=root->val;
        }
        dfs(root->left,depth+1);
        // st.pop();
        dfs(root->right,depth+1);
        
        
    }
    
};