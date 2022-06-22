//Time Complexity- O(n)
//Space Complexity- O(h) (Recursive Stack)

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        
        vector<int> ans;
        dfs(ans,root,0);
        return ans;
    }
    
    void dfs(vector<int> &ans,TreeNode* root,int level){
        if(root==NULL){
            return;
        }
        
        if(ans.size()==level){
            ans.push_back(root->val);
        }
        dfs(ans,root->right,level+1);
        dfs(ans,root->left,level+1);
    }
};