// Approach 1 - BFS
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(n), since at max we can have a total of 'n/2' elements in the queue.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<int> answer;
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL)
            return answer;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode* curr = q.front(); q.pop();
                if(i == size - 1)
                    answer.push_back(curr->val);
                if(curr->left)
                    q.push(curr->left);
                if(curr->right)
                    q.push(curr->right);
            }
        }
        return answer;
    }
};

// Approach 2 - DFS - hitting the left child first.
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(h), recursive stack space.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<int> answer;
    private:
    void dfs(TreeNode* root, int level){
        // base
        if(root == NULL)
            return;
        // logic
        if(level == answer.size())
            answer.push_back(root->val);
        else
            answer[level] = root->val;
        
        dfs(root->left, level+1);
        dfs(root->right, level+1);
    }
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return answer;
        dfs(root, 0);
        return answer;
    }
};

// Approach 3 - DFS - hitting the right child first.
// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(h), recursive stack space.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<int> answer;
    private:
    void dfs(TreeNode* node, int lvl){
        // base
        if(node == NULL)
            return;
        // logic
        if(lvl == answer.size())
            answer.push_back(node->val);
        dfs(node->right, lvl+1);
        dfs(node->left, lvl+1);
    }
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL)
            return answer;
        dfs(root, 0);
        return answer;
    }
};
