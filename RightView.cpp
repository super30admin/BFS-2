//tc-o(n)
//sc-o(h)
class Solution {
public:vector<int> result;
    void fill(TreeNode*root,int level){
        if(!root)return;
        if(result.size()==level){
            result.push_back(root->val);
        }
        fill(root->right,level+1);
            fill(root->left,level+1);
        
    }
    vector<int> rightSideView(TreeNode* root) {
        // fill(root,0);
        if(!root)return {};
        deque<TreeNode*> q;
        q.push_back(root);
        while(!q.empty()){
            int rightmostval=q.back()->val;
            result.push_back(rightmostval);
            int k=q.size();
            while(k--){
            auto temp=q.front();
            q.pop_front();
            if(temp->left)q.push_back(temp->left);
            if(temp->right)q.push_back(temp->right);
            
        }
        }
        return result;
    }
};