// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use a queue to store each node and it's children.
// Increment the parent count while traversing it's children.
// If the value is found, increment children and parent count.
// If parent count is 2, then the children have same parent, return false. If children count is 1, only one child is found return false.
// If children count is 2 then there are 2 children at the same level, return true.
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
            if(root == NULL) return false;
            queue<TreeNode*> q;
            q.push(root);
            while(!q.empty()){
                int cc = 0;
                int n = q.size();
                for(int i=1; i<=n; i++){
                    TreeNode* curr = q.front();
                    q.pop();
                    int pc = 0;
                    if(curr->left){
                        if(curr->left->val == x || curr->left->val == y){
                            pc++;
                            cc++;
                        } 
                        q.push(curr->left);
                    }
                    if(curr->right){
                        if(curr->right->val == x || curr->right->val == y){
                            pc++;
                            cc++;
                        } 
                        q.push(curr->right);
                    }
                    if(pc == 2) return false;
                }
                if(cc == 2) return true;
                if(cc == 1) return false;
            }
            return false;
        }
    };