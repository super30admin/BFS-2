//Time Complexity O(n)
// Space Complexity O(height of tree)(Due to recursion)
//Problem successfully executed on leetcode
//No problems faced while coading this.



#include<iostream>
#include<vector>
using namespace std;

  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
 
class Solution {
public:
    int x_level;
    TreeNode* x_parent;
    int y_level;
    TreeNode* y_parent;
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL) return false;
        
        dfs(root,x,y,0,NULL);
        return ((x_level==y_level) && (x_parent!=y_parent));
        
    }
    
    void dfs(TreeNode* root, int x, int y,int level,TreeNode* parent)
    {
        if(root==NULL)
        {
            return;
        }
        if(x_parent!=NULL and y_parent!=NULL)
        {
            return;
        }
        if(root->val==x)
        {
            x_level= level;
            x_parent=parent;
        }
        
        if(root->val==y)
        {
            y_level=level;
            y_parent=parent;
        }
        
        dfs(root->left,x,y,level+1,root);
        dfs(root->right,x,y,level+1,root);
    }
};