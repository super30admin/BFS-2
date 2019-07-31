//
// Created by shazm on 7/30/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

// Runtime: O(n)
// Space: O(n)
// Approach: Use BFS to add elements to the queue. If any element is equal to x or y, save it's parent node. and keep note
// of the value checked. Then go through the stack if the other value not found in the same level with different parent,
// return false. Repeat till queue is empty.

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class Solution{
public:
    bool isCousins(TreeNode* root, int i, int y) {
        if(root==NULL || (root->left==NULL || root->right == NULL)){return false;}
        queue<pair<TreeNode*,TreeNode*>> que;
        que.push(pair<TreeNode*,TreeNode*>(root->left,root));
        que.push(pair<TreeNode*,TreeNode*>(root->right,root));
        TreeNode* node; TreeNode* checkNode; bool checkx = false; bool checky = false; int size = 0;
        while(!que.empty()){
            size = que.size();
            for(int x = 0; x<size; x++){
                node = get<0>(que.front());
                if(node->val == i){
                    if(checky == true && checkNode != get<1>(que.front())){return true;}
                    checkx = true;
                    checkNode = get<1>(que.front());
                }else if(node->val == y){
                    if(checkx == true && checkNode != get<1>(que.front())){return true;}
                    checky = true;
                    checkNode = get<1>(que.front());
                }
                if(node->left!=NULL){
                    que.push(pair<TreeNode*,TreeNode*>(node->left,node));
                }
                if(node->right!=NULL){
                    que.push(pair<TreeNode*,TreeNode*>(node->right,node));
                }
                que.pop();
            }
            if(checkx||checky){break;}
        }
        return false;
    }
};