993. Cousins in Binary Tree

//DFS
/*
class Solution {
public:
    TreeNode* xParent = NULL, *yParent = NULL;
    int xDepth = -1, yDepth = -2;
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root, NULL, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }
    void dfs(TreeNode* root, TreeNode* parent, int x, int y, int depth) {
        if (root == NULL) return;
        if (x == root->val) {
            xParent = parent;
            xDepth = depth;
        } else if (y == root->val) {
            yParent = parent;
            yDepth = depth;
        } else {
            dfs(root->left, root, x, y, depth + 1);
            dfs(root->right, root, x, y, depth + 1);
        }
    }
};
*/

//BFS
/* 
class Solution {
public:
bool isCousins(TreeNode* root, int x, int y) {
  queue<TreeNode*> q, pq;
  q.push(root);
  pq.push(root);
  TreeNode* px = NULL; TreeNode* py = NULL;
    while (!q.empty()) {
      int size = q.size();  
       bool x_found = false;
       bool y_found = false;
       for (int i=0; i< size; i++) {
           TreeNode *curr = q.front();
           q.pop();
           TreeNode *pCurr = pq.front();
           pq.pop();
           if (curr->val == x) {
               x_found = true;
               px = pCurr;
           } 
           if (curr->val == y) {
               y_found = true;
               py = pCurr;
           }     
           if (curr->left != NULL) {
               q.push(curr->left); pq.push(curr);
           }                 
           if (curr->right != NULL) {
               q.push(curr->right); pq.push(curr);
           }
       } 
       if (x_found && y_found) return px != py;
       if (x_found || y_found) return false;
    }
    return false;
}
};
*/

