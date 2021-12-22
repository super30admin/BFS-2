//Time Complexity O(n)
// Space Complexity O(n)(Elements in queue)(Although all the elements will never be in the queue at a time unless it has only 1 node)
//Problem successfully executed on leetcode
//No problems faced while coading this.



#include<iostream>
#include<vector>
#include<queue>
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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        if(root==NULL) return result; 
        
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            int queueSize=q.size();
            for(int i=0;i<queueSize;i++)
            {
                TreeNode* cur=q.front();
                q.pop();
                if(i==queueSize-1)
                {
                    result.push_back(cur->val);
                }
                if(cur->left!=NULL)
                {
                    q.push(cur->left);
                }
                if(cur->right!=NULL)
                {
                    q.push(cur->right);
                }
                
            }
        }
        return result;
        
        
    }
};