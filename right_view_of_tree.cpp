 //Time = O(n)
 //Space = O(n)
 //Leetcode: yes
 //issue seen: none
class Solution {
public:
   vector<int> ans;
   void dfs(TreeNode* root, int level){
    if(!root) return;
    if(level == ans.size()){
        ans.push_back(root->val);
    } else {
        ans[level]= root->val;
    }
    dfs(root->left, level+1);
    dfs(root->right, level+1);

   }
   vector<int> rightSideView(TreeNode* root) {  
    if(!root) return ans;
    int level=0;
    dfs(root,level);
    return ans;

    }
    /*vector<int> rightSideView(TreeNode* root) {
        queue<TreeNode*> q;
        vector<int> ans;
        if (!root)
            return ans;

        q.push(root);
        while (!q.empty()) {
            int n = q.size();
            int rightmost=0;;
            for(int i=1; i <= n; i++) {
                TreeNode* node = q.front();
                q.pop();
                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
                if(i==n) {
                    rightmost = node->val;
                }    
            }
            ans.push_back(rightmost);
        }
        return ans;
    }*/
};
