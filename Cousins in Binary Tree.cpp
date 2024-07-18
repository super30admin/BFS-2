// time: O(n)
// space: O(n)

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
        if(root->val == x || root->val == y) {
            return false;
        }
        int parent1, parent2;
        bool f1 = false, f2 = false;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            
            int sz = q.size();    
            for(int i = 0; i < sz; i++) {
                
                TreeNode* curr = q.front();
                
                q.pop();
                if(curr->left != NULL) {
                    if(curr->left->val == x) {
                        f1 = true;
                        parent1 = curr->val;
                    }
                    else if(curr->left->val == y) {
                        f2 = true;
                        parent2 = curr->val;
                    }
                    q.push(curr->left);
                }
                if(curr->right != NULL) {
                    if(curr->right->val == x) {
                        f1 = true;
                        parent1 = curr->val;
                    }
                    else if(curr->right->val == y) {
                        f2 = true;
                        parent2 = curr->val;
                    }
                    q.push(curr->right);
                }
                
                    
            }
            if(f1) {
                if(f2) {
                    if(parent1 != parent2) {
                        return true; // cousins
                    }
                    return false; // siblings
                }
                return false;
            }
            if(f2) {
                if(!f1) {
                    return false;
                }
            }
            
            
        }
        return false;
    }
};