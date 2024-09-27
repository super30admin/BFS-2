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
 where N is the number of nodes of the tree and h is the hieght of the tree.
 */
class Solution {
public:
    int x_depth, y_depth;
    TreeNode* x_parent;
    TreeNode* y_parent;
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root,x,y,0,NULL);
        return (x_depth==y_depth && x_parent!=y_parent);   
    }
    void dfs(TreeNode* root,  int x, int y, int depth, TreeNode* parent)
    {
        //base
        if(root==NULL)
            return;
        
        //logic
        if(x==root->val)
        {
            x_depth = depth;
            x_parent = parent;
        }
        
        if(y==root->val)
        {
            y_depth = depth;
            y_parent = parent;
        }
        dfs(root->left, x,y,depth+1, root);
        dfs(root->right, x,y,depth+1, root);
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
 Space Complexity = O(N)
 Where N is the number of nodes of the tree.
 */
class Solution {
public:
    int x_depth, y_depth;
    TreeNode* x_parent;
    TreeNode* y_parent;
    bool isCousins(TreeNode* root, int x, int y) {
        queue <TreeNode*> q;
        q.push(root);
        int count=0;
        if(root->val == x)
        {
            x_depth=count;
            x_parent = NULL;
        }
        if(root->val == y)
        {
            y_depth=count;
            y_parent = NULL;
        }
        count++;
        while(!q.empty())
        {
            vector <int> ans;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode* temp = q.front();
                q.pop();
                if(temp->left!=NULL)
                {
                    q.push(temp->left);
                    if(temp->left->val==x)
                    {
                        x_depth=count;
                        x_parent = temp;
                    }
                    if(temp->left->val==y)
                    {
                        y_depth=count;
                        y_parent = temp;
                    }
                }
                if(temp->right!=NULL)
                {
                    q.push(temp->right);
                    if(temp->right->val==y)
                    {
                        y_depth=count;
                        y_parent = temp;
                    }
                    if(temp->right->val==x)
                    {
                        x_depth=count;
                        x_parent = temp;
                    }
                }
            }
            count++;
        }
        cout<<x_depth<<" "<<y_depth<<" "<<x_parent<<" "<<y_parent<<endl;
        return (x_depth==y_depth && x_parent!=y_parent);
    }
};
