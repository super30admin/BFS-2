// Approach 1 - DFS
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(h) - recursive stack
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    TreeNode* x_parent;
    TreeNode* y_parent;
    int x_ht; int y_ht;
    private:
    void dfs(TreeNode* root, TreeNode* parent, int level, int x, int y){
        if(root == NULL)
            return;
        if(root->val == x){
            x_parent = parent;
            x_ht = level;
        }
        if(root->val == y){
            y_parent = parent;
            y_ht = level;
        }
        dfs(root->left, root, level+1, x, y);
        dfs(root->right, root, level+1, x, y);
    }
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL)
            return false;
        dfs(root, NULL, 0, x, y);
        return x_parent != y_parent && x_ht == y_ht;
    }
};

// Approach 2 - BFS
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            bool x_flag = false;
            bool y_flag = false;
            for(int i = 0; i < size; i++){
                TreeNode* curr = q.front(); q.pop();
                if(curr->val == x) x_flag = true;
                if(curr->val == y) y_flag = true;
                if(curr->left && curr->right){
                    if(curr->left->val == x && curr->right->val == y) return false;
                    if(curr->right->val == x && curr->left->val == y) return false;
                }
                if(curr->left)
                    q.push(curr->left);
                if(curr->right)
                    q.push(curr->right);
            }
            if(x_flag && y_flag) return true;
            if(x_flag || y_flag) return false;
        }
        return false;
    }
};