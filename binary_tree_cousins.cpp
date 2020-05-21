//Time Complexity-O(n)
//Space Complexity-O(h) and O(n/2)
//Ran successfully on leetcode
//3 point algo-
	//1a)In dfs, we recursively go through all the elemets in the tree.
	//1b)When we encounter x or y value, we store its depth and its parent.
	//1c)finally we compare x and y values and return the result
	//2a)In bfs, we check if the current value is equal to x or y. If so, then we set its boolean found variable to true
    //2b)For every level, we need to check if the left and right nodes of a particular parents are equal to x and y.If so, we return false.
    //2c)If not, then we add to the queue.
	//2d)In the end, we check if x_found and y_found are true. If so, we return true. Else, false.
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
//dfs solution
class Solution {
    int x_depth=0,y_depth=0;
    TreeNode*x_parent=NULL;
    TreeNode*y_parent=NULL;
public:
    /*dfs
	bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL)
            return false;
        dfs(root,0,x,y,NULL);
        return (x_depth==y_depth)&&(x_parent!=y_parent);
    }
    void dfs(TreeNode* root,int depth,int x,int y,TreeNode*parent)
    {
        if(root==NULL)
            return;
        if(root->val==x)
        {
            x_depth=depth;
            x_parent=parent;
        }
        if(root->val==y)
        {
            y_depth=depth;
            y_parent=parent;
        }
        dfs(root->left,depth+1,x,y,root);
        dfs(root->right,depth+1,x,y,root);
    }*/
    //bfs solution
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL)
            return false;
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty())
        {
            bool x_found=false;
            bool y_found=false;
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode*curr=q.front();
                q.pop();
                if(x==curr->val)
                    x_found=true;
                if(y==curr->val)
                    y_found=true;
                if(curr->left!=NULL && curr->right!=NULL)
                {
                    if(curr->left->val==x && curr->right->val==y)
                        return false;
                    if(curr->left->val==y && curr->right->val==x)
                        return false;
                }
                if(curr->left!=NULL)
                    q.push(curr->left);
                if(curr->right!=NULL)
                    q.push(curr->right);
            }
            if(x_found==true&&y_found==true)
                return true;
        }
        return false;
    }
};