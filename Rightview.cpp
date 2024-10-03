// tc o(n), sc o(n)
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(!root) return {};
        vector<int> ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            bool isFirst  = true;
            while(size--) {
                TreeNode *front = q.front();
                q.pop();
                if(isFirst) {
                   ans.push_back(front->val);
                   isFirst  = false;
                }
                if(front->right) {
                    q.push(front->right);
                }
                if(front->left) {
                    q.push(front->left);
                }
            }
        }
        return ans;
    }
};