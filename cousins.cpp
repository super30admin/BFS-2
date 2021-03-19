
// TC: O(N); where N is the nodes in the tree
// SC: O(N/2)

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
        queue<pair<TreeNode*,int>>q;
        if(root == NULL)return false;
        int parentX = -1;
        int parentY = -1;
        q.push({root,-1});
        while(!q.empty()){
            int size = q.size();
            int parentX = -1;
            int parentY = -1;
            for(int i = 0; i < size;i++){
            pair<TreeNode*,int>root = q.front();q.pop();
            if(root.first->val == x)parentX = root.second;
            else if((root.first)->val == y)parentY = root.second;
            if((root.first)->left)q.push({(root.first)->left,root.first->val});
            if((root.first)->right)q.push({(root.first)->right,root.first->val});
            }
            if(parentX != -1 && parentY!= -1 && parentX!=parentY)return true;   
        }
        return false;
         
        
    }
};