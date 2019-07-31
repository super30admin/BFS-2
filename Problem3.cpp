//
// Created by shazm on 7/31/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x): val(x), left(NULL), right(NULL){}
};

class Solution{
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> retVec;
        if(root==NULL){return retVec;}
        queue<TreeNode*> que;
        que.push(root);
        int i = 0;
        TreeNode* node; int size;
        while(!que.empty()){
            vector<int> vec;
            size = que.size();
            for(int x = 0; x<size; x++){
                node = que.front();
                if(vec.empty() || i%2==0){
                    vec.push_back(node->val);
                }else{
                    vec.insert(vec.begin(),node->val);
                }
                if(node->left!=NULL){
                    que.push(node->left);
                }
                if(node->right!=NULL){
                    que.push(node->right);
                }
                que.pop();
            }
            i++; retVec.push_back(vec);
        }
        return retVec;
    }
};