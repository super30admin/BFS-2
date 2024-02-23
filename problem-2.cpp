// 993. Cousins in Binary Tree
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
utilizes a breadth-first search (BFS) traversal with a queue to explore nodes level by level, 
keeping track of the depth and parent node values for the target nodes. If the target nodes are 
found and meet the cousin conditions, the flag is set to true; otherwise, it remains false.

*/
class Solution {
public:
    bool flag = true;
    vector<int> dep = {0, 0, 0, 0};
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> q;
        q.push(root);
        int level = 0;
        while(!q.empty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                root = q.front();
                q.pop();
                if(root->left!=NULL)
                {
                    q.push(root->left);
                    if(dep[0] == 0 && root->left->val == x)
                    {
                        dep[0] = root->val;
                        dep[2] = level + 1;
                    }
                    if(dep[1] == 0 && root->left->val == y)
                    {
                        dep[1] = root->val;
                        dep[3] = level + 1;
                    }
                }
                if(root->right!=NULL)
                {
                    q.push(root->right);
                    if(dep[0] == 0 && root->right->val == x)
                    {
                        dep[0] = root->val;
                        dep[2] = level + 1;
                    }
                    if(dep[1] == 0 && root->right->val == y)
                    {
                        dep[1] = root->val;
                        dep[3] = level + 1;
                    }
                }
            }
            level++;
        }
        if(dep[0] == dep[1] || dep[2] != dep[3])
                flag = false;
        return flag;

    }
};