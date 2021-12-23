//Time complexity : O(n)
//Space complexity : O(n/2) = O(n)

//Approach:
            // BFS : Traverse the tree level by level
            // At each level check whether x and y exist in the same level
            // At the same time make sure that children of the current node are not x and y

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
        if(root == nullptr)
            return false;
        
        queue<TreeNode*> q;
        
        q.push(root);
        
        while(!q.empty())
        {
            bool x_found = false;
            bool y_found = false;
            
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                TreeNode* ptr = q.front();
                q.pop();
                
                if(ptr->val == x)
                {
                    x_found = true;
                }
                if(ptr->val == y)
                {
                    y_found = true;
                }
                
                if(ptr->left && ptr->right && ((ptr->left->val == x) && (ptr->right->val == y)))
                {
                    return false;
                }
                
                if(ptr->left && ptr->right && ((ptr->left->val == y) && (ptr->right->val == x)))
                {
                    return false;
                }
                
                if(ptr->left)
                    q.push(ptr->left);
                if(ptr->right)
                    q.push(ptr->right);
            }
            
            if(x_found == true && y_found == false)
            {
                return false;
            }
            
            if(x_found == false && y_found == true)
            {
                return false;
            }
            
            if(x_found && y_found)
            {
                return true;
            }
        }
        
        return false;
    }
};