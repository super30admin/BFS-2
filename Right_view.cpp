
// TC:O(N), 
// SC:O(2^H)
// BFS soloution

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int>ans;
        if(root==nullptr) return ans;

        queue<TreeNode*>q;
        q.push(root);

        while(!q.empty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode* p=q.front();
                q.pop();

                if(i==s-1)
                ans.push_back(p->val);

                if(p->left !=nullptr)
                q.push(p->left);
                if(p->right!=nullptr)
                q.push(p->right);



            }

        }
        return ans;
        
    }
};

// TC:O(N), 
// SC:O(H)
// DFS soloution

// here doing a preorder traversal with right element as first
// Right node left
class Solution {
public:
    vector<int>ans;
    vector<int> rightSideView(TreeNode* root) {
        if(root==nullptr)
        return ans;

        dfs(root,0);
        return ans;
    }

    void dfs(TreeNode* root,int lvl)
    {
        if(root==nullptr) return;
        // adding into ans vector if ans vector size is same as lvl
        if(ans.size()==lvl)
        ans.push_back(root->val);

        dfs(root->right,lvl+1);
        dfs(root->left,lvl+1);
    }
};