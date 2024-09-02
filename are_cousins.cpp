// Time : O(N)
// Space: O(N)

// Level order traversal
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        
        // level order traversal 
        queue<TreeNode*> q; 
        q.push(root);

        int level = 0;
        int x_level = -1;
        int y_level = -2;

        while(q.empty() == false)
        {
            int q_size = q.size();
            for(int i = 0; i < q_size ; i++)
            {
                TreeNode* node = q.front();
                q.pop();
                if(node->left && node->right)
                {
                    // check if siblings, return false if they are 
                    if(x == node->left->val && y == node->right->val)return false;
                    if(y == node->left->val && x == node->right->val)return false;
                }

                // If not siblings, find and store levels
                if(node->val == x)
                {
                    x_level = level;
                }
                if(node->val == y)
                {
                    y_level = level;
                }

                if(node->left)
                {
                    q.push(node->left);
                }

                if(node->right)
                {
                    q.push(node->right);
                }
            }
            // After every level check if x and y were found,
            // if yes and their levels are same, that means they are cousins
            if(x_level > 0 && y_level > 0)
            {
                if(x_level == y_level)
                {
                    return true;
                }
                return false;
            }

            level++;
        }

        if(x_level == y_level) return true;
        return false;
    }
};