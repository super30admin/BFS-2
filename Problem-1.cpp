// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use a queue to store the nodes from each level.
// When the size of the queue is equal to the curr element, it is the rightmost element of that level. 
// Push it into the answer.

class Solution {
    public:
        vector<int> rightSideView(TreeNode* root) {
            vector<int> ans;
            if(root == NULL){
                return ans;
            }
            queue<TreeNode*> q;
            q.push(root);
            while(!q.empty()){
                int n = q.size();
                for(int i=1; i<=n; i++){
                    TreeNode* curr = q.front();
                    q.pop();
                    if(i==n){
                        ans.push_back(curr->val);
                    }
                    if(curr->left) q.push(curr->left);
                    if(curr->right) q.push(curr->right);
                }
            }
            return ans;
        }
    };

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursively iterate the tree, right subtree first followed by left.
// push the node value when the output vector size is equal to the level
    class Solution {
        public:
            void helper(TreeNode *root, vector<int> &ans, int level){
                if(root == NULL) return;
                if(ans.size() == level){
                    ans.push_back(root->val);
                }
                helper(root->right, ans, level+1);
                helper(root->left, ans, level+1);
            }
            vector<int> rightSideView(TreeNode* root) {
                vector<int> ans;
                helper(root, ans, 0);
                return ans;
            }
        };