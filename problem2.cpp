// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// we do DFS. we know that we are required to compare parents , so use a function in which we pass the parent as well.
// we need to have level also in the function. we do dfs similar to preorder traversal.
// we check for x and y values and if found, we store their level and parent. we then compare at the end;


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
public:
    int x_lvl = -1,y_lvl = -1;
    TreeNode* x_parent = NULL;
    TreeNode* y_parent = NULL;
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL) return false;
        dfs(root,NULL, x,y,0);
        // cout << "x-parent "<< x_parent->val << "  y_parent "<< y_parent->val<< endl;
        // cout << "x_lvl "<< x_lvl << "  y_level "<< y_lvl<< endl;
        if(x_parent != y_parent && x_lvl == y_lvl) return true;
        return false;
        
    }
    void dfs(TreeNode* root,TreeNode* parent,int x,int y,int level)
    {
        //base
        if(root ==NULL) return;
        
        //logic
        if(root->val==x){
            x_lvl = level;
            x_parent = parent;
        }
        else if(root->val == y)
        {
            y_lvl = level;
            y_parent = parent;
        }
        
        dfs(root->left,root,x,y,level+1);
        dfs(root->right,root,x,y,level+1);
    }
};




// using BFS , as we traverse level by level, we dont need to check for level specifically.
// we just need to handle a case where parent is same. if x or y is found , we update their boolean value.
// and after each level , we check those variables (x_found and y_found) and return answer accordingly.

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
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL) return NULL;
        queue<TreeNode*>q;
        q.push(root);
        int lvl = 0;
        while(!q.empty())
        {
            int n = q.size();
            bool x_found = false;
            bool y_found = false;
            while(n--)
            {
                TreeNode* curr = q.front();q.pop();
                if(curr->val == x) x_found = true;
                if(curr->val == y) y_found = true;
                if(curr->left!=NULL && curr->right!=NULL)
                {
                    if(curr->left->val == x && curr->right->val==y) return false;
                    if(curr->left->val == y && curr->right->val==x) return false;
                }
                if(curr->left!=NULL) q.push(curr->left);
                if(curr->right!=NULL) q.push(curr->right);
            }
            if(x_found && y_found) return true;
        }
        return false;
    }
};