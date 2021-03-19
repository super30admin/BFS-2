//TC: O(n)
//SC: O(n) where n is nodes. (SC is due to the recursion stack growing)

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
    
    vector<int> ans;
    
    void dfs(TreeNode* root, int level){
        if(root == NULL)
            return;
        //do dfs, if there is not yet an element added for a level, add it to the answer vector.
        if(ans.size() == level){
            ans.push_back(root->val);
        } else{
            //if there is an element added for a level, then we update this since we will always be travelling the right node after the left node at any level. 
            ans[level] = root->val;
        }
        
        dfs(root->left, level+1);
        dfs(root->right, level+1);
                
    }
    
    
    vector<int> rightSideView(TreeNode* root) {
                        
        dfs(root, 0);        
        return ans;
        
//         level order traversal, and keep only the last element

//         queue<TreeNode*> q;
//         q.push(root);
//         if(root==NULL)
//             return ans; 
        
//         while(!q.empty()){
//             int qsize = q.size();            
//             int last;
//             for(int i=0; i<qsize; i++){
//                 TreeNode *curr = q.front();
//                 q.pop();
//                 if(curr->left!=NULL)
//                     q.push(curr->left);
//                 if(curr->right!=NULL)
//                     q.push(curr->right);
//                 last = curr->val;
//             }
//             ans.push_back(last);
            
//         }
                
        // return ans;
        
    }
};