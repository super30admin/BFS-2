// time : O(N)
// space: O(N) recursion stacl

// Another approach: Do Level order traversal using BFS and store last element of every level in the result
// DFS: 
class Solution {
public:
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode* root, int level)
    {
        // base
        if(root == nullptr)
        {
            return;
        }

        // logic
        if(result.size() < level+1)
        {
            result.push_back(root->val);
        }
        dfs(root->right, level+1);
        dfs(root->left, level+1);

    }
};