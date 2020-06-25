//Time Complexicity = O(n)
//Space Complexicity = O(h)
//Runs Successfully on the Leetcode
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
    TreeNode* x_parent; TreeNode* y_parent;
    int x_depth; int y_depth;
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL)
            return false;
        dfs(root,NULL,0,x,y);
            return x_depth == y_depth && x_parent != y_parent;
}
private:
        void dfs(TreeNode* root, TreeNode* parent, int depth,int x, int y){
            //base case
            if(root == NULL) return;
            if(root->val == x){
                x_parent = parent; 
                x_depth = depth;
            }
            if(root->val == y){
                y_parent = parent;
                y_depth = depth;
            }
            dfs(root->left, root, depth+1, x, y);
            dfs(root->right, root, depth+1, x,y);
        }
};