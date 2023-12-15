/*Perform a level-order traversal (BFS) of the binary tree, tracking the rightmost node at each level.
For each level, add the value of the rightmost node to the result vector.
Return the vector containing the rightmost values at each level, representing the right side view.

Time Complexity: O(N), where N is the number of nodes in the binary tree, as each node is visited once during the BFS traversal.
Space Complexity: O(W), where W is the maximum width of the tree (width is the number of nodes on the level with the most nodes). 
In the worst case, the queue can store all nodes at the widest level.*/
#include<bits/stdc++.h>
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
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        if(root==nullptr)return result;
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode* curr=q.front();
                q.pop();
                if(i==size-1){
                    result.push_back(curr->val);
                }
                if(curr->left!=nullptr){
                    q.push(curr->left);
                }
                if(curr->right!=nullptr){
                    q.push(curr->right);
                }
            }
        }
        return result;
    }
};