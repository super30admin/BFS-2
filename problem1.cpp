
// Time Complexity : O(n)
// Space Complexity : O(n/2) which is O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// BFS

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
public:
    vector<int> rightSideView(TreeNode* root) {

        vector<int>answer;
        if( root == nullptr ){
            return answer;
        }
        list<TreeNode*>temp;
        temp.push_back( root );
        answer.push_back(root->val);
        while( temp.size()){
            int size = temp.size();
            while( size ){
                TreeNode* node = temp.front();
                temp.pop_front();
                if( node->left != nullptr ){
                    temp.push_back( node->left);
                }
                if( node->right != nullptr ){
                    temp.push_back( node->right);
                }
                size--;
            }
            if( temp.size()){
               answer.push_back( temp.back()->val);
            }
        }
        return answer;
    }
};
