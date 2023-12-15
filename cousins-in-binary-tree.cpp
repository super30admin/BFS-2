/*
Use level-order traversal (BFS) to explore the binary tree, maintaining separate queues for nodes and their corresponding parents.
Track the parent nodes of the target values x and y and ensure they have different parents, indicating they are at the same level but not siblings.
If x and y are both found, return true; otherwise, return false.

Time Complexity: O(N), where N is the number of nodes in the binary tree, as each node is visited once during the BFS traversal.
Space Complexity: O(W), where W is the maximum width of the tree (width is the number of nodes on the level with the most nodes). In the worst case, the two queues can store all nodes at the widest level.
*/
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
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*>q;
        queue<TreeNode*>parentQ;
        q.push(root);
        parentQ.push(NULL);
        while(!q.empty()){
            int size=q.size();
            TreeNode* xParent=NULL;
            TreeNode* yParent=NULL;
            bool xFound=false;
            bool yFound=false;
            for(int i=0;i<size;i++){
                TreeNode* curr=q.front();
                q.pop();
                TreeNode* parent=parentQ.front();
                parentQ.pop();
                if(curr->val==x){
                    xFound=true;
                    xParent=parent;
                }
                if(curr->val==y){
                    yFound=true;
                    yParent=parent;
                }
                if(curr->left!=nullptr){
                    q.push(curr->left);
                    parentQ.push(curr);
                }
                 if(curr->right!=nullptr){
                    q.push(curr->right);
                    parentQ.push(curr);
                }
            }
            if(xFound && yFound)return xParent!=yParent;
            if(xFound || yFound)return false;
        }
    return false;
    }
};