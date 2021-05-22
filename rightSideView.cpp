// Time Complexity :O(N) where n in the number of nodes
// Space Complexity : O(D) D-> Diameter of the binary tree 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
    vector<int> ans;
public:
    vector<int> rightSideView(TreeNode* root) {
        //BFS 
        /*vector<int> ans,level;
        queue<TreeNode*> q;
        if(!root) return ans;
        q.push(root);
        int size;
        while(!q.empty()){
            level.clear();
            size = q.size();
            while(size--){
                root = q.front();
                q.pop();
                if(root){
                    if(size == 0) ans.push_back(root->val);
                    q.push(root->left);
                    q.push(root->right);
                }               
            }
        }
        return ans;*/
        
        //DFS
        dfs(root,0);
        return ans;
    }
    void dfs(TreeNode* root, int level){
        if(!root) return;
        if(level == ans.size())
            ans.push_back(root-> val);
        else 
            ans[level] = root->val;
        dfs(root->left,level+1);
        dfs(root->right,level+1);
        
    }
};