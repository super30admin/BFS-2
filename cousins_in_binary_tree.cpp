// Time Complexity : O(n*h)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this
// Not the most efficient solution. Can be better

class Solution {
public:
    // Function to check if the 2 nodes have same or different parents
    bool check_child(TreeNode* root, int x, int y)
    {
        if(root == NULL)
            return false;
        
        if(root->left && root->right)
        {}
            if(root->left->val == x || root->right->val == x)
                if(root->left->val == y || root->right->val == y)
                    return true;
            
            return check_child(root->left, x, y) || check_child(root->right, x, y);
        }
        else
        {
            return check_child(root->left, x, y) || check_child(root->right, x, y);
        }
    }
    
    // Main Function called
    bool isCousins(TreeNode* root, int x, int y) {
        
        queue<pair<TreeNode*, int>> q;
        pair<TreeNode*, int> temp; 
        bool flag = false;
        vector<vector<int>> ret_vect;
        
        if(root == NULL)
            return false;
        
        q.push({root, 0});
        
        // 2D Vector created with Level Order traversal
        // Each level nodes present in a different vector

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
                ret_vect[temp.second].push_back(temp.first->val);
            
            if(temp.first->left)
                q.push({temp.first->left, temp.second+1});
            
            if(temp.first->right)
                q.push({temp.first->right, temp.second+1});
        }

        // Check if both nodes are at same level

        for(int i = 0; i < ret_vect.size(); i++)
        {
            if(find(ret_vect[i].begin(), ret_vect[i].end(), x) != ret_vect[i].end())
                if(find(ret_vect[i].begin(), ret_vect[i].end(), y) != ret_vect[i].end())
                {
                    flag = true; break;
                }    
        }

        // Check if the nodes at same level have same parents or not        
        if(flag == true)
            return !check_child(root, x, y);
        
        return false;
    }
};