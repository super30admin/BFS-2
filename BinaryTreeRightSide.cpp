//Time Complexity: O(n)
//Space complexity: O(n)

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
    vector<int> result; 
    vector<int> rightSideView(TreeNode* root) {
        if(root == nullptr) return {}; 
        bfs(root); 
        return result;     
    }

    void bfs(TreeNode* node) {
        deque<TreeNode*> q; 
        q.push_back(node); 

        while(!q.empty()) {
            int size = q.size(); 
            while(size > 1) {
                TreeNode* n = q.front();
                q.pop_front();  
                if(n->left != nullptr) q.push_back(n->left); 
                if(n->right != nullptr) q.push_back(n->right); 
                size--; 
            }
            TreeNode* n = q.front(); 
            q.pop_front();
            result.push_back(n->val); 
            if(n->left != nullptr) q.push_back(n->left); 
            if(n->right != nullptr) q.push_back(n->right);  
        }
    }
};