//Time O(n)
//Space - O(n)

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ret;
        if(root==NULL) return ret;
        queue<TreeNode*> q;
        q.push(root);
        TreeNode* node;
        int size =0;
        
        while(!q.empty()){
            size = q.size();
            ret.push_back(q.front()->val);
            for(int i=0;i<size;i++){
                node = q.front();q.pop();
                if(node->right) q.push(node->right);
                if(node->left) q.push(node->left);
            }
        }
        
        return ret;
    }
};