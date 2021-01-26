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
class Solution {
    TreeNode* x_parent;
    TreeNode* y_parent;
    int x_depth;
    int y_depth;
public:
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root, NULL, 0,x ,y);
        return x_parent != y_parent && x_depth == y_depth;
        
    }
        
private:
    void dfs(TreeNode* root, TreeNode* parent, int depth, int x, int y){ // we need to check x and y if its present and then check the level of each and their parent in the recusrsive stack
        //base
        if(root==NULL) return;
        
        //logic
        if(root->val==x){
            x_parent=parent;
            x_depth=depth;
        }
        if(root->val==y){
            y_parent=parent;
            y_depth=depth;
        }
        dfs(root->left,root,depth+1,x,y);
        //st.pop()
        dfs(root->right,root,depth+1,x,y);
         
               
    }    
};

// class Solution {

// public:
//     bool isCousins(TreeNode* root, int x, int y) {
        
//         queue<TreeNode*> q; //in BFSwe have a queue
//         q.push(root); //first we must push the node in the queue
        
//         while(!q.empty()){
//             int size=q.size();
//             bool x_found=false;
//             bool y_found=false;
            
//             for(int i=0; i<size; i++){
                
//                 TreeNode* curr=q.front(); //in JAVA this is TreeNode curr=q.poll()
//                 q.pop();
                
//                 if(curr->val==x) x_found=true;
//                 if(curr->val==y) y_found=true;
//                 if(curr->left != NULL && curr->right != NULL){
//                     if(curr->left->val == x && curr->right->val ==y) return false;
//                     if(curr->left->val == y && curr->right->val ==x) return false;
//                 }
//                 if(curr->left != NULL) q.push(curr->left);
//                 if(curr->right != NULL) q.push(curr->right); 
//             }
//             if(x_found== true && y_found==true) return true;
//             if(x_found== true || y_found==true) return false;
            
//         }
//         return false;
        
//     }
        
  
// };