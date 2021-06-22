// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        
        queue<pair<TreeNode*, int>> q;
        pair<TreeNode*, int> temp;
        
        vector<vector<int>> ret_vect;
        vector<int> temp_vector;

        // 2D Vector created with Level Order traversal
        // Each level nodes present in a different vector

        if(root == NULL)
            return temp_vector;
        
        q.push({root, 0});
        
        while(!q.empty())
        {
            temp = q.front();
            q.pop();
            
            if(ret_vect.size() <= temp.second)
            {
                vector<int> vect;
                vect.push_back(temp.first->val);
                ret_vect.push_back(vect);
            }
            else
            {
                ret_vect[temp.second].push_back(temp.first->val);
            }
            
            if(temp.first->left)
                q.push({temp.first->left, temp.second+1});
            
            if(temp.first->right)
                q.push({temp.first->right, temp.second+1});
        }

        // Add the last node from each vector level to the return vector        
        for(int i = 0; i < ret_vect.size(); i++)
        {
            int n = ret_vect[i].size();
            temp_vector.push_back(ret_vect[i][n-1]);
        }
        
        return temp_vector;
    }
};