199. Binary Tree Right Side View

//BFS 
 //TC O(n)
 //SC O(n)
 /*
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if (root == NULL) return {};
        vector<int> result; 
        queue<TreeNode* > q;
        q.push(root);

        while (!q.empty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode* temp = q.front();
                q.pop();
                if (i == size-1) {
                    result.push_back(temp->val);
                }
                if (temp->left)q.push(temp->left);
                if (temp->right)q.push(temp->right);
            }
        }
        return result;
    }
};
*/

/*
 //DFS  with recursing right first. 
 //TC O(n)
 //SC O(n)
 class Solution {
     vector<int> result;

public:
    vector<int> rightSideView(TreeNode* root) {
        if (root == NULL) return {};
        dfs(root, 0);
        return result;
    }
    void dfs(TreeNode* root, int depth) {
        if (root == NULL) return;
        if(result.size() == depth) {
            result.push_back(root->val);
        }
        dfs(root->right, depth+1);
        dfs(root->left, depth+1);
    }
};

