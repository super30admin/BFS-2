// Time Complexity :  O(n) 
// Space Complexity : O(n) -> ((n/2) nodes in queue at max)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english

/* BFS appoach :- 
 *  Push the root node in queue and repeat following steps till queue is not empty.
 *     a) Get the current size of queue.
 *     b) For i = 0 to size - 1 pop element from queue, add its childrens to queue and if i == size -1 then add popped element in result vector.
 * Return result vector.
 */


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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        
        if (root == nullptr)
            return result;
        
        queue<TreeNode*> q;
        int size;
        q.push(root);
        
        while (!q.empty())
        {
            size = q.size();
            
            for (int i = 0; i < size; i++)
            {
                TreeNode* node = q.front();
                q.pop();
                
                if (i == size - 1)
                    result.push_back(node->val);
                
                if (node->left != nullptr)
                    q.push(node->left);
                
                if (node->right != nullptr)
                    q.push(node->right);
            }
        }
        return result;
    }
};