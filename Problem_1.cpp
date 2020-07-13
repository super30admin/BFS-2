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
         queue<TreeNode*> Q;
         Q.push(root);
        int counter = 0; 
        while(!Q.empty()){
            counter = Q.size();
            bool a = false;
            bool b = false;
            for(int i=0; i<counter; i++){
                TreeNode* temp = Q.front();
                Q.pop();
                if(temp->val == x) a=true;
                if(temp->val == y) b=true;
                if(temp->left!=NULL) {
                    Q.push(temp->left);
                }
                if(temp->right!=NULL) {
                    Q.push(temp->right);
                }
                if(temp->left!=NULL && temp->right!= NULL){
                    if(temp->left->val == x && temp->right->val == y) return false;
                    if(temp->left->val == y && temp->right->val == x) return false;
                }
            }
            if((a==true)&&(b==true)){
                return true;
            }
        }
        return false;
    }
};