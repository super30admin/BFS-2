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

//Time complexity : O(n)
//Space complexity : O(n/2) : O(n)

//Approach :
            // Traverse each level of the tree left to right
            // While traversing, add the last element of the level into resultant array
            // Return the resultant array

class Solution {
public:
    
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result(0);
        if(root == nullptr)
            return result;
        
        queue<TreeNode *> q;
        q.push(root);
        
        while(!q.empty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                TreeNode* ptr = q.front();
                q.pop();
                if(i == size - 1)
                {
                    result.push_back(ptr->val);
                }
                
                if(ptr->left)
                    q.push(ptr->left);
                if(ptr->right)
                    q.push(ptr->right);
            }
        }
        
        return result;
    }
};