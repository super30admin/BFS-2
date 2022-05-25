//time = O(N)
//Space = O(N)

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return {};
        queue<TreeNode*> q;
        vector<int> result;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode *curr = q.front(); q.pop();
                if(i==size-1) result.push_back(curr->val);
                if(curr->left!=NULL) q.push(curr->left);
                if(curr->right!=NULL) q.push(curr->right); 
            }
        }
        return result;
    }
};
