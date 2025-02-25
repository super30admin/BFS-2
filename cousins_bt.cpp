// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. We will use BFS traversal to traverse the tree level by level.
// 2. We will maintain a deque to store the nodes at each level.
// 3. We will push the root node into the deque.
// 4. We will iterate over the deque until it is empty.
// 5. For each level, we will check if the nodes x and y are found.
// 6. If both x and y are found at the same level, we will return true.
// 7. If x and y are found at different levels, we will return false.

class Solution {
    public:
        bool isCousins(TreeNode* root, int x, int y) {
            if(root == nullptr){return false;}
            deque<TreeNode*> q;
            q.push_back(root);
            while(!q.empty()){
                int count = q.size();
                bool x_found = false;
                bool y_found = false;
                for(int i = 0; i < count; i++){
                    TreeNode* node = q.front();
                    q.pop_front();
                    if(node -> val == x){x_found = true;}
                    if(node -> val == y){y_found = true;}
                    if(node -> left != nullptr && node -> right != nullptr){
                        if(node -> left -> val == x && node -> right -> val == y){return false;}
                        if(node -> left -> val == y && node -> right -> val == x){return false;}
                    }
                    if(node -> left != nullptr){
                        q.push_back(node -> left);
                    }
                    if(node -> right != nullptr){
                        q.push_back(node -> right);
                    }
                }
                if(x_found && y_found){return true;}
            }
            return false;
        }
    };