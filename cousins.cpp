//TC = O(N) 
//SC = O(N)

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL) return false;
        queue<TreeNode*> q;
        bool found_x = false;
        bool found_y = false;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode* curr = q.front(); q.pop();
                if(curr->val == x) found_x = true;
                if(curr->val == y) found_y = true;
                if(curr->left!=NULL && curr->right!=NULL){
                    if(curr->left->val==x && curr->right->val==y
                    || curr->right->val ==x && curr->left->val==y) return false;
                }
                if(curr->left!=NULL) q.push(curr->left);
                if(curr->right!=NULL) q.push(curr->right);
            }
            if(found_x && found_y) return true;
            if(found_x || found_y) return false;
        }
        return false;
    }
};
