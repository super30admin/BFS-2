// Time Complexity: O(n)
// Space Complexity: O(n)
//Did this code successfully run on Leetcode : Yes

// Approach:
// 1. We will use BFS traversal to traverse the tree level by level.
// 2. We will maintain a deque to store the nodes at each level.
// 3. We will push the root node into the deque.
// 4. We will iterate over the deque until it is empty.
// 5. For each level, we will store the last element of the deque in a temp variable.
// 6. We will iterate over the nodes at each level and push the left and right child of the node into the deque.
// 7. Finally, we will push the temp variable into the result vector.

class Solution {
    public:
        vector<int> rightSideView(TreeNode* root) {
            vector<int> result; 
            if(root == nullptr){return result;}
            deque<TreeNode*> q;
            q.push_back(root);
            while(!q.empty()){
                int temp;
                int count = q.size();
                for(int i = 0; i < count; i++){
                    TreeNode* node = q.front();
                    q.pop_front();
                    temp = node -> val;
                    if(node -> left != nullptr){
                        q.push_back(node -> left);
                    }
                    if(node -> right != nullptr){
                        q.push_back(node -> right);
                    }
                }
                result.push_back(temp);
            }
            return result;
        }
    };