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
 Time Complexity = O(N)
 Space Complexity = O(N)
 where N is the number of nodes in the tree.
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ans;
        if(root==NULL)
            return ans;
        queue <TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode* temp = q.front();
                q.pop();
                if(temp->left!=NULL)
                    q.push(temp->left);
                if(temp->right!=NULL)
                    q.push(temp->right);
                if(i==size-1)
                    ans.push_back(temp->val);
            }
        }
        return ans;
    }
};



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
  Time Complexity = O(N)
 Space Complexity = O(h)
 where N is the number of nodes in the tree and h is the height of the tree.
 */
class Solution {
public:
    vector<int> ans;
    vector<int> rightSideView(TreeNode* root) {
        if(root==NULL)
            return ans;
        dfs(root,0);
        return ans;
    }
    void dfs(TreeNode *root, int lvl)
    {
        //base
        if(root==NULL)
            return;
        //logic
        if(lvl==ans.size())
            ans.push_back(root->val);
        dfs(root->right,lvl+1);
        dfs(root->left,lvl+1);
    }
};



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
  Time Complexity = O(N)
 Space Complexity = O(h)
 where N is the number of nodes in the tree and h is the height of the tree.
 */
class Solution {
public:
    vector<int> ans;
    vector<int> rightSideView(TreeNode* root) {
        if(root==NULL)
            return ans;
        dfs(root,0);
        return ans;
    }
    void dfs(TreeNode *root, int lvl)
    {
        //base
        if(root==NULL)
            return;
        //logic
        if(lvl==ans.size())
            ans.push_back(root->val);
        else
            ans[lvl] = root->val;
        dfs(root->left,lvl+1);
        dfs(root->right,lvl+1);
    }
};
