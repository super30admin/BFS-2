/* Time Complexity : O(n)
Space complexity : ?
Did it run on LeetCode : Yes
Any Problems faced : Took some online help to code out the solution.
*/

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> queue;
        
        if (!root) 
        {
            return false;
        }
        
        queue.push(root);
        
        while (!queue.empty()) {
           
            bool has_x = false;
            bool has_y = false;
           
            int level_size = queue.size();
            
            for (int i = 0; i < level_size; i++) 
            {
                TreeNode* current = queue.front();
                queue.pop();
                
                if (current->val == x) {
                    has_x = true;
                }
                if (current->val == y) {
                    has_y = true;
                }
                // Check if x and y are sibling
                if (current->left && current->right) {
                    if (current->left->val == x && current->right->val == y) {
                        return false;
                    }
                    if (current->right->val == x && current->left->val == y) {
                        return false;
                    }
                }
                if (current->left) {
                    queue.push(current->left);
                }
                if (current->right) {
                    queue.push(current->right);
                }
            }
            if (has_x && has_y) {
                return true;
            }
            
            if (has_x || has_y) {
                return false;
            }
        }
        return false;
    }
};